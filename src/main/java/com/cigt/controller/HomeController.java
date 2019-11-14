package com.cigt.controller;

import com.cigt.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 */
@RestController("/api")
public class HomeController {
    @Autowired
    private HomeService homeService;
    /**
     * 获取商品信息
     */
    @PostMapping("/getAllGoodsInfo")
    public Map getAllGoodsInfo(){
        Map map = new HashMap();
        try {
            List ls = homeService.getAllGoods();
            map.put("getAllGoods",ls);
            return map;
        }catch (Exception e){
            System.out.println(e);
        }
        map.put("getAllGoods","false");
        return map;
    }
    
}