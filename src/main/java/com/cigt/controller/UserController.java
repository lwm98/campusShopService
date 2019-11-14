package com.cigt.controller;

import com.cigt.dto.UserDto;
import com.cigt.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 用户登录
     */
    @PostMapping("/loginInfo")
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
}
