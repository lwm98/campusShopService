package com.cigt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前端页面路由控制器
 */
@Controller
public class UrlRouteController {
    @GetMapping("/login")
    public String login(){ return "login"; }
}
