package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.ibatis.annotations.*;

/**
 * 操作t_user表
 */
@Mapper
public interface UserMapper {
    /**
     * 异步
     */
    @Select("select name from t_user where name = #{name}")
    String findUserNameByUserName(@Param("name") String name);
    /**
     * 注册
     */
    @Insert("INSERT INTO t_user (name,password) VALUES (#{name},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    int insertUser(UserDto userDto);
    /**
     * 登录
     */
    @Select("select * from t_uers where name = #{name},password = #{password}")
    UserDto findUser(UserDto userDto);
    /**
     * 修改个人信息
     */
    @Update("update t_user set ")
    int updateUser(UserDto userDto);
}
