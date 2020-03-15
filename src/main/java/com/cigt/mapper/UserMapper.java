package com.cigt.mapper;

import com.cigt.dto.UserDto;
import org.apache.catalina.User;
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
    @Insert("INSERT INTO t_user (name,password,role,created_at,updated_at) " +
            "VALUES (#{name},#{password},#{role},#{created_at},#{updated_at})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    int insertUser(UserDto userDto);
    /**
     * 登录
     */
    @Select("select * from t_user where name = #{name} and password = #{password}")
    UserDto findUser(UserDto userDto);
    /**
     * 修改个人信息
     */
    @Update("update t_user set image=#{image},address = #{address},sex = #{sex}," +
            "phone = #{phone},Information_state=#{Information_state}," +
            "autograph=#{autograph},updated_at=#{updated_at}," +
            "real_name=#{real_name}" +
            " where id = #{id}")
    int updateUser(UserDto userDto);
    /**
     * 修改密码
     */
    @Update("update t_user set password =#{password} ,updated_at=#{updated_at} where id = #{id}")
    int updateUserPassword(@Param("password") String password,
                           @Param("id") int id,
                           @Param("updated_at") String updated_at);
    /**
     * 修改用户头像
     */
    @Update("update t_user set image =#{imagePath} where id = #{id}")
    int updateUserImage(@Param("imagePath") String imagePath,
                        @Param("id") int user_id);
    /**
     * 获取新闻的用户部分信息
     */
    @Select("select name,image,sex,real_name from t_user where id = #{id}")
    UserDto getNewsUser(@Param("id")int id);
}
