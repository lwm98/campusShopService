package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
@Api(tags = "首页接口")
@CrossOrigin(origins = "*",maxAge = 3600)
public class HomeController {
    @Autowired
    private HomeService homeService;
    /**
     * 获取动态加载商品信息
     */
    @PostMapping("/getLoadmMoreGoodsInfo/{category}")
    @ApiOperation("商品加载更多")
    public R getLoadmMoreGoodsInfo(@PathVariable("category") String category,
                                   @RequestParam(defaultValue = "1",value = "pageNum") int pageNum){

        return homeService.getLoadmMoreGoods(category, pageNum);
    }
    /**
     * 分类查询
     */
    @PostMapping("/getGoodsCategoryInfo/{category}")
    @ApiOperation("分类查询")
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
    @ApiOperation("获取商品分类")
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
    @ApiOperation("查询商品")
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
