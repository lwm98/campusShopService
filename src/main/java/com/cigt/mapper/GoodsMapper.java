package com.cigt.mapper;

import com.cigt.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 操作Goods表
 */
@Mapper
public interface GoodsMapper {
    /**
     * 获取所有商品信息
     */
    @Select("select * from goods")
    List<GoodsDto> getAllGoods();
}
