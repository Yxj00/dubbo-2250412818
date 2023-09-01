package com.icss.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.icss.pojo.Cabinet;
import com.icss.service.ListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {
    @Reference
    private ListService listService;

    @RequestMapping("/")
    public String toIndex(Model model, String position, String courierName){
        PageInfo<Cabinet> pageInfo = listService.selectList(1, 3, position, courierName);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("position",position);
        model.addAttribute("courierName",courierName);
        return "index";
    }
    @RequestMapping("/cc")
    public String toPage(Model model, @RequestParam(defaultValue = "1") Integer pageNum, String position, String courierName){
        PageInfo<Cabinet> pageInfo = listService.selectList(pageNum, 3, position, courierName);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("position",position);
        model.addAttribute("courierName",courierName);
        return "index";
    }
}
