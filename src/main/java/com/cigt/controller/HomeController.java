package com.cigt.controller;

import com.cigt.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private HomeService homeService;
    /**
     * 获取动态加载商品信息
     */
    @PostMapping("/getLoadmMoreGoodsInfo")
    public Map getLoadmMoreGoodsInfo(int goodsNum){
        Map map = new HashMap();
        try {
            List ls = homeService.getLoadmMoreGoods(goodsNum);
            map.put("getAllGoods",ls);
            return map;
        }catch (Exception e){
            System.out.println(e);
        }
        map.put("getAllGoods","false");
        return map;
    }
    /**
     * 分类查询
     */
    @PostMapping("/getGoodsCategoryInfo/{category}")
    public Map getGoodsByCategoryInfo(@PathVariable("category") String category){
        Map map =new HashMap();
        try {
            List ls = homeService.getGoodsByCategory(category);
            map.put("getCategory",ls);
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("getCategory","false");
            return map;
        }
    }
    /**
     * 获取分类表
     */
    @PostMapping("/getCategoryInfo")
    public List getCategoryInfo(){
        List ls = null;
        try{
            ls=homeService.getGoodsCategory();
            return ls;
        }catch (Exception e){
            System.out.println(e);
            ls.add("false");
            return null;
        }
    }
    /**
     * 查询商品接口
     */
    @PostMapping("/findGoodsInfo")
    public Map findGoodsInfo(String goodsName){
        Map map = new HashMap();
        try {
            List ls = homeService.findGoodsByName(goodsName);
            map.put("findGoods",ls);
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("findGoods","false");
            return map;
        }
    }
}
