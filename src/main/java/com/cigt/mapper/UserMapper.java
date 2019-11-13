package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.ibatis.annotations.*;

/**
 * 操作users表
 */
@Mapper
public interface UserMapper {
    /**
     * 异步
     */
    @Select("select user_name from users where user_name = #{user_name}")
    String findUserNameByUserName(@Param("user_name") String user_name);
    /**
     * 注册
     */
    @Insert("INSERT INTO users (user_name,password) VALUES (#{user_name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "user_id",keyColumn="user_id")
    int insertUser(UserDto userDto);
    /**
     * 登录
     */
    @Select("select * from uers where user_name = #{user_name},password = #{password}")
    UserDto findUser(UserDto userDto);
}
