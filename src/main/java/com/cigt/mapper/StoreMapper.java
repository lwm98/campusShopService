package com.cigt.mapper;


import com.cigt.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    /**
     * 查询所有商铺信息
     */
    @Select("select * from t_store")
    List<StoreDto> getAllStore();

    /**
     *  查询商区内所有商铺
     */
    @Select("select * from t_store where area_id=#{id}")
    List<StoreDto> getStoreByArea(@Param("id")int id);

    /**
     *  查询单一商铺信息
     */
    @Select("select * from t_store where id=#{id}")
    List<StoreDto> getStoreByid(@Param("id")int id);
}
