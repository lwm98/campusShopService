package com.cigt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 前端页面路由控制器
 */
@Controller
public class UrlRouteController {

    @GetMapping("/index")       //首页
    public String index(){
        return "index";
    }

    @GetMapping("/register")     //注册
    public String register(){
        return "register";
    }

    @GetMapping("/category")     //购物
    public String category(){
        return "category";
    }

    @GetMapping("/basket")      //购物车
    public String basket(){
        return "basket";
    }

    @GetMapping("/detail")      //详情
    public String detail(){
        return "detail";
    }

    @GetMapping("/userinfo")      //我的信息
    public String userinfo(){
        return "userinfo";
    }

    @GetMapping("/usergood")      //我的商品
    public String usergood(){
        return "usergood";
    }

    @GetMapping("/userorder")      //我的订单
    public String userorder(){
        return "userorder";
    }
}
