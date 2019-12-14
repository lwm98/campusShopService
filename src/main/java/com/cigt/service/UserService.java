package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.UserDto;
import com.cigt.mapper.UserMapper;
import com.cigt.my_util.GetTime_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 用来处理用户操作的事务
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GetTime_util getTime_util;

    /**
     * 用户登录事务
     */
    public UserDto userLogin(UserDto userDto){
        userDto = userMapper.findUser(userDto);
        return userDto;
    }
    /**
     * 用户测试异步事务
     */
    public boolean registerAsynchronous(String user_name){
        String st = userMapper.findUserNameByUserName(user_name);
        if(st!=null){
            return false;
        }
        return true;
    }
    /**
     * 用户注册事务
     */
    public UserDto userRegister(UserDto userDto){
        //修改时间
        userDto.setCreated_at(getTime_util.GetNowTime_util());
        userDto.setUpdated_at(getTime_util.GetNowTime_util());
        userMapper.insertUser(userDto);
        return userDto;
    }
    /**
     * 用户修改个人信息
     */
    public void updateUser(UserDto userDto){
        userDto.setUpdated_at(getTime_util.GetNowTime_util());
        userMapper.updateUser(userDto);
    }
    /**
     * 修改用户密码
     */
    public void updateUserPassword(String password,int id){
        String updated_at = getTime_util.GetNowTime_util();
        userMapper.updateUserPassword(password,id,updated_at);
    }

    /**
     * 修改用户头像
     */
    public R updateUserImage(String userImage,int user_id){
        try {
            userMapper.updateUserImage(userImage, user_id);
            return R.ok("修改成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("修改出错");
        }
    }
}
