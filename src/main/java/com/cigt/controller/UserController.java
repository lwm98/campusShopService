package com.cigt.controller;

import com.cigt.dto.GoodsDto;
import com.cigt.dto.UserDto;
import com.cigt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于一些用户操作的控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
@Api(tags = "用户操作接口（多为操作个人信息）")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户登录
     */
    @PostMapping("/loginInfo")
    @ApiOperation("用户登录")
    public Map loginInfo(UserDto userDto,HttpServletRequest request){
        Map map =new HashMap();
        userDto = userService.userLogin(userDto);
        if(userDto!=null){
            map.put("login","true");
            //加入session
            HttpSession sessoin=request.getSession();
            sessoin.setAttribute("USER",userDto);
            return map;
        }
        map.put("login","false");
        return map;
    }

    /**
     * 用户注册
     */
    @PostMapping("/registerInfo")
    @ApiOperation("用户注册")
    public Map registerInfo(UserDto userDto, HttpServletRequest request){
        Map map =new HashMap();
        try {
            userDto = userService.userRegister(userDto);
            //保存到session中
            HttpSession sessoin=request.getSession();
            sessoin.setAttribute("USER",userDto);
            map.put("register","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
        }
        map.put("register","false");
        return map;
    }

    /**
     * 注册时的异步判断
     */
    @PostMapping("/registerAsynchronousInfo")
    @ApiOperation("异步判断")
    public Map registerAsynchronousInfo(String user_name){
        Map map =new HashMap();
        try {
            boolean bl = userService.registerAsynchronous(user_name);
            //如果不存在
            if(bl){
                map.put("registerAsynchronous","true");
                return map;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        map.put("registerAsynchronous","false");
        return map;
    }
    /**
     * 修改用户信息
     */
    @PostMapping("/updateUserInfo")
    @ApiOperation("修改用户信息")
    public Map updateUserInfo(UserDto userDto){
        Map map =new HashMap();
        try{
            userService.updateUser(userDto);
            map.put("updateUser","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("updateUser","false");
            return map;
        }
    }
    /**
     * 修改密码
     */
    @PostMapping("/updateUserPasswordInfo")
    @ApiOperation("修改密码")
    public Map updateUserPasswordInfo(String password,int id ){
        Map map = new HashMap();
        try {
            userService.updateUserPassword(password,id);
            map.put("updateUserPassword","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
            map.put("updateUserPassword","false");
            return map;
        }
    }
    /**
     * 发布商品
     */
    @PostMapping("/releaseGoodsInfo")
    @ApiOperation("发布商品")
    public Map releaseGoodsInfo(GoodsDto goodsDto){
        return null;
    }

}
