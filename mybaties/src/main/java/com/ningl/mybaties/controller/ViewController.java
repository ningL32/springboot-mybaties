package com.ningl.mybaties.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *@program: mybaties
 *@description: 页面跳转
 *@author: ningl
 *@create: 2019.2.26-0.0
 */
@Controller
public class ViewController {

    @GetMapping("/index.html")
    public ModelAndView index(ModelAndView mv){
        mv.setViewName("index.html");
        return mv;
    }
}
