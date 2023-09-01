package com.icss.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icss.pojo.Cabinet;
import com.icss.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class FetchController {
    @Reference
    private FetchService fetchService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("fetch")
    public String toFetch(){
        return "fetch";
    }
    @RequestMapping("sendCode")
    @ResponseBody
    public String sendCode(String usernameTel, Cabinet cabinet){
        try {
            // 生成6位数字验证码
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append( random.nextInt(10));
            }
//            // 验证码生成
//            // 调用短信服务，给手机号发短信
//            // 把验证码存入redis，1分钟之内有效
            cabinet.setGetCode(sb.toString());
            System.out.println(cabinet.getGetCode());
            fetchService.updateCabinet(cabinet.getGetCode(), usernameTel);
            stringRedisTemplate.opsForValue().set(usernameTel,sb.toString());
            stringRedisTemplate.expire(usernameTel, Duration.ofSeconds(60));
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
}

    @PostMapping("checkCode")
    @ResponseBody
    public Map<String, String> selectByPositionAndAddress(HttpServletRequest request){
        String usernameTel = request.getParameter("usernameTel");
        String getCode = request.getParameter("getCode");
        Cabinet cabinet = fetchService.selectByPositionAndAddress(usernameTel);
        HashMap<String, String> map = new HashMap<>();
        if (cabinet.getGetCode().equals(getCode)){
            map.put("position",cabinet.getPosition());
            map.put("address",cabinet.getAddress());
        }else {
            map.put("error","您输入的取件码无效！请点击确定重新输入！！！");
        }

        return map;
    }
    @RequestMapping("out")
    public String out(String getCode,String usernameTel,Model model){
        System.out.println(getCode);
        Cabinet cabinet1 = fetchService.selectByUsernameTel(usernameTel);
        System.out.println(cabinet1.getGetCode());
        System.out.println(usernameTel);
    if (cabinet1.getGetCode().equals(getCode)){
        System.out.println("成功");
        return "redirect:/cc";
    }else{
        System.out.println("失败");
        return "redirect:fetch";
    }
    }
}
