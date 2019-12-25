package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.dto.ShoppingDto;
import com.cigt.service.ShoppingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 购物车订单控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
@CrossOrigin(origins = "*",maxAge = 3600)
@Api(tags = "购物车订单接口")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    /**
     * 获取购物车
     */
    @PostMapping("/getShoppingByUserIdInfo")
    @ApiOperation("获取购物车")
    public R getShoppingByUserIdInfo(int user_id){ return shoppingService.allShoppingByUserId(user_id); }

    /**
     * 插入购物车
     */
    @PostMapping("/insertShoppingInfo")
    @ApiOperation("插入购物车")
    public R insertShoppingInfo(int goods_id,
                                int number,
                                String user_address,
                                int userId ){
        return shoppingService.insertShopping(goods_id,number,user_address,userId);
    }

    /**
     * 删除购物车
     */
    @PostMapping("/deleteShoppingInfo")
    @ApiOperation("删除购物车")
    public R deleteShoppingInfo(int id){ return shoppingService.deleteShopping(id); }

    /**
     * 修改购物车
     */
    @PostMapping("/updateShoppingInfo")
    @ApiOperation("修改购物车")
    public R updateShoppingInfo(int id,int number,String user_address){ return shoppingService.updateShopping(id,number,user_address); }

    /**
     * 查询订单
     */
    @PostMapping("/getOrderByUserIdInfo")
    @ApiOperation("查询订单")
    public R getOrderByUserIdInfo(int user_id){ return shoppingService.allOrderByUserId(user_id); }

    /**
     * 单个支付接口
     */
    @PostMapping("/successPayOneInfo")
    @ApiOperation("单个支付接口")
    public R successPayInfo(int user_id,int goods_id,int number){ return shoppingService.successPayOne(user_id,goods_id,number); }

    /**
     * 多个商品支付接口
     */
    @PostMapping("/successPayInfo")
    @ApiOperation("多个支付接口")
    public R successPayInfo(int[] id) { return shoppingService.successPay(id);  }
}
