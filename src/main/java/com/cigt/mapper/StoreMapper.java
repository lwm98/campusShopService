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
    @Select("select * from t_store where id= #{id}")
    List<StoreDto> getAllStore(@Param("id") int id);
}
