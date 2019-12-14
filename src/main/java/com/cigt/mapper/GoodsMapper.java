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
     * 获取所有商品信息
     */
    @Select("select * from t_goods limit #{currIndex} , #{pageSize}")
    List<GoodsDto> getLoadmMoreGoods(@Param("currIndex") int currIndex,
                               @Param("pageSize") int pageSize);

    /**
     * 依靠类别模糊查询商品
     */
    @Select("select * from t_goods where category like CONCAT('%',#{category},'%')")
    List<GoodsDto> findGoodsByCategory(@Param("category") String category);

    /**
     * 查询种类
     */
    @Select("select * from t_category")
    List<CategoryDto> findAllCategory();

    /**
     * 模糊查询商品
     */
    @Select("select * from t_goods where name like CONCAT('%',#{name},'%')")
    List<GoodsDto> findGoodsByName(@Param("name") String name);

    /**
     * 模糊查询商品
     */
    @Select("select * from t_goods where id = #{id}")
    List<GoodsDto> findGoodsById(@Param("id") int id);
}
