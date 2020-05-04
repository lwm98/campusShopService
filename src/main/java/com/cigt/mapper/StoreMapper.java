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
     *  查询商区内已租赁所有商铺
     */
    @Select("select * from t_store where area_id=#{id} and status = 1")
    List<StoreDto> getStoreByArea(@Param("id")int id);

    /**
     *  查询单一商铺信息
     */
    @Select("select * from t_store where id=#{id}")
    List<StoreDto> getStoreByid(@Param("id")int id);

    /**
     * 查询所有商铺列表
     */
    @Select("select * from t_store")
    List<StoreDto> getAllStoreList();

    /**
     * 查询所有未租赁的商铺
     */
    @Select("select * from t_store where status = 1")
    List<StoreDto> getAllzlStore();
    /**
     * 查询所有未租赁的商铺
     */
    @Select("select * from t_store where status = 0")
    List<StoreDto> getAllwzlStore();

}
