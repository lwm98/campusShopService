package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dao.GoodsDAO;
import com.cigt.dto.GoodsDto;
import com.cigt.dto.UserDto;
import com.cigt.mapper.GoodsMapper;
import com.cigt.mapper.UserMapper;
import com.cigt.my_util.GetTime_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用来处理用户操作的事务
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GetTime_util getTime_util;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsDAO goodsDAO;

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

    /**
     * 发布商品
     */
    public R publishedGoods(GoodsDto goodsDto){
        //设置时间
        goodsDto.setTime(getTime_util.GetNowTime_util());
        try {
            //插入商品
            int goodsNum = goodsMapper.insertGoods(goodsDto);
            //插入商品轮播图
            int bannerNum = goodsDAO.updateGoodsBannerImages(goodsDto);
            if(goodsNum==1&&bannerNum==1){
                return R.ok("发布商品成功，可以在个人中心看到哦");
            }
        }catch (Exception e){
            System.out.println("发表商品失败"+e);
            return R.error("发表商品失败");
        }
        return R.error("发表商品失败");
    }

    /**
     * 获取用户个人商品
     * @param userId
     * @return
     */
    public R findUserGoods(int userId){
        try {
            List<GoodsDto> goodsDtoList = goodsMapper.findUserGoods(userId);
            return R.ok(goodsDtoList);
        }catch (Exception e){
            System.out.println("获取个人商品错误"+e);
            return R.error("获取个人商品错误");
        }
    }

    /**
     * 删除自己的商品
     */
    public R delUserGoods(int goodsId){
        System.out.println(goodsId);
        try {
            goodsMapper.updateGoodsStatus(goodsId);
            return R.ok("删除自己的商品成功");
        }catch (Exception e){
            System.out.println("删除自己的商品失败"+e);
            return R.error("删除自己的商品失败");
        }
    }
}
