package com.cigt.dao;

import com.cigt.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品的dao
 */
@Mapper
public interface GoodsDAO {
    /**
     * 分页获取更多商品信息
     * @return
     */
    List<List<?>> getLoadmMoreGoods(@Param("category") String category,
                                     @Param("pageNum") int pageNum);

    /**
     * 修改轮播图
     */
    int updateGoodsBannerImages(@Param("goods")GoodsDto goodsDto);
}
