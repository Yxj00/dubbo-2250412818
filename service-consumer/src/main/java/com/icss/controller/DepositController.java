package com.icss.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icss.pojo.Cabinet;
import com.icss.pojo.Courier;
import com.icss.pojo.Record;
import com.icss.service.DepositService;
import com.icss.service.FetchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("deposit")
public class DepositController {
    @Reference
    private DepositService depositService;
    @Reference
    private FetchService fetchService;
    //根据id进行查询数据返回给页面
    @RequestMapping("{id}")
    public String selectById(@PathVariable String id, Model model){
        //查出t_express_cabinet表中数据
        Cabinet cabinet = depositService.selectById(id);
        //查出所有快递员姓名
        List<String> name = depositService.selectCourierName();
        model.addAttribute("cabinet",cabinet);
        model.addAttribute("name",name);
        return "deposit";
    }
    //选取快递员姓名时，自动填充公司和手机号
    @PostMapping("findByName")
    @ResponseBody
    public Map<String, String> selectByName(HttpServletRequest request){
        String courierName = request.getParameter("courierName");
        Courier courier = depositService.selectByName(courierName);
        HashMap<String, String> map = new HashMap<>();
        map.put("company",courier.getCompany());
        map.put("courierTel",courier.getCourierTel());
        return map;
    }

    //存入时的操作
    @RequestMapping("update")
    public String dataUpdate(Cabinet cabinet){
        depositService.updateCabinet(cabinet);
        //更新t_courier
        depositService.updateCourier(cabinet.getCourierName());
        //给t_express_record添加数据
        Courier courier = depositService.selectByName(cabinet.getCourierName());
        Record record = new Record(cabinet.getPosition(),cabinet.getAddress(),cabinet.getCourierName(),courier.getCourierTel());
        depositService.insertRecord(record);
        return "redirect:/cc";
    }

}
