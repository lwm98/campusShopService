package com.cigt.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cigt.base.R;
import com.cigt.dto.GoodsDto;
import com.cigt.dto.UserDto;
import com.cigt.service.FileUpService;
import com.cigt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@CrossOrigin(origins = "*",maxAge = 3600)
@Transactional
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileUpService fileUpService;
    /**
     * 用户登录
     */
    @PostMapping("/loginInfo")
    @ApiOperation("用户登录")
    public Map loginInfo(UserDto userDto,HttpSession session){
        System.out.println("x");
        Map map =new HashMap();
        userDto = userService.userLogin(userDto);
        if(userDto!=null){
            map.put("login","true");
            //加入session
           // session.setAttribute("USER",userDto);
            map.put("User",userDto);
            System.out.println(map.get("User"));
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
            map.put("User",userDto);
            map.put("register","true");
            return map;
        }catch (Exception e){
            System.out.println(e);
        }
        map.put("register","false");
        return map;
    }

    /**
     * 用户退出
     */
    @PostMapping("/loginOut")
    @ApiOperation("用户退出")
    public R UserLoginOut(HttpServletRequest request){
        //保存到session中
        HttpSession sessoin=request.getSession();
        sessoin.setAttribute("USER",null);
        return R.ok();
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
     * 用户上传头像
     */
    @PostMapping("/upUserImage")
    @ApiOperation("用户上传图片")
    public R upUserImage(@RequestParam("fileName") MultipartFile userImage,
                         int type){
        return fileUpService.upload(userImage,type);
    }

    /**
     * 确定修改用户头像
     */
    @PostMapping("/updateUserImage")
    @ApiOperation("修改用户头像")
    public R updateUserImage(String imagePath,HttpServletRequest request){
        //从session中获取用户信息
        HttpSession sessoin=request.getSession();
        UserDto userDto = (UserDto) sessoin.getAttribute("USER");
        return userService.updateUserImage(imagePath,userDto.getId());
    }

    @PostMapping("/publishedGoods")
    @ApiOperation("发表商品")
    public R publishedGoods(GoodsDto goodsDto,int userId){
        //从session中获取用户信息
       // HttpSession sessoin=request.getSession();
        //UserDto userDto = (UserDto) sessoin.getAttribute("USER");
        goodsDto.setUser_id(userId);
        return userService.publishedGoods(goodsDto);
    }

    @PostMapping("/findUserGoods")
    @ApiOperation("查看自己的商品")
    public R findUserGoods(int userId){
        //从session中获取用户信息
       // HttpSession sessoin=request.getSession();
        //UserDto userDto = (UserDto) sessoin.getAttribute("USER");
        return userService.findUserGoods(userId);
    }

    @PostMapping("/delUserGoods")
    @ApiOperation("删除自己的商品")
    public R delUserGoods(int goodsId){
        //从session中获取用户信息
       // HttpSession sessoin=request.getSession();
       // UserDto userDto = (UserDto) sessoin.getAttribute("USER");
        return userService.delUserGoods(goodsId);
    }

    /**
     * 获取新闻的用户信息
     */
    @GetMapping("/getNewsUser")
    public R getNewsUser(int id){
        return userService.getNewsUser(id);
    }
}
