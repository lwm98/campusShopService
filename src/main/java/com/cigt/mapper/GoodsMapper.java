package com.cigt.mapper;

import com.cigt.dto.CategoryDto;
import com.cigt.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作t_goods表
 */
@Mapper
public interface GoodsMapper {


    /**
     * 依靠类别模糊查询商品
     */
    @Select("select * from t_goods where category like CONCAT('%',#{category},'%') LIMIT 0,8 ")
    List<GoodsDto> findGoodsByCategory(@Param("category") String category);

    /**
     * 获取种类
     */
    @Select("select * from t_category")
    List<CategoryDto> findAllCategory();

    /**
     * 模糊查询商品
     */
    @Select("select * from t_goods where name like CONCAT('%',#{name},'%')")
    List<GoodsDto> findGoodsByName(@Param("name") String name);

}
