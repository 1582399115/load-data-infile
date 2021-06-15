package com.xinlei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class Test {
    @RequestMapping("/a")
    @ResponseBody
    public String test(){
        return "你还要?";
    }
}
