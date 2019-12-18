package com.cigt.mapper;

import com.cigt.dto.CategoryDto;
import com.cigt.dto.GoodsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 操作t_goods表
 */
@Mapper
public interface GoodsMapper {


    /**
     * 依靠类别模糊查询商品
     */
    @Select("select * from t_goods where status = 0 and category like CONCAT('%',#{category},'%') LIMIT 0,8 ")
    List<GoodsDto> findGoodsByCategory(@Param("category") String category);

    /**
     * 获取种类
     */
    @Select("select * from t_category")
    List<CategoryDto> findAllCategory();

    /**
     * 模糊查询商品
     */
    @Select("select * from t_goods where status = 0 and name like CONCAT('%',#{name},'%')")
    List<GoodsDto> findGoodsByName(@Param("name") String name);

    /**
     * 模糊查询商品
     */
    @Select("select * from t_goods where id = #{id}")
    List<GoodsDto> findGoodsById(@Param("id") int id);
    /**
     * 发布商品
     **/
    @Insert("insert into t_goods (name,depict,price,images,time," +
            "user_id,num,category" +
            ") VALUES (#{name},#{depict},#{price},#{images},#{time}," +
            "#{user_id},#{num},#{category})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    int insertGoods(GoodsDto goodsDto);

    /**
     * 获取用户个人商品
     */
    @Select("select * from t_goods where user_id = #{user_id}")
    List<GoodsDto> findUserGoods(@Param("user_id") int user_id);

    /**
     * 更改商品状态
     */
    @Update("update t_goods set status = 1 where user_id = #{userId} and id = #{id}")
    int updateGoodsStatus(@Param("userId ") int userId,
                          @Param("id") int id);
}
