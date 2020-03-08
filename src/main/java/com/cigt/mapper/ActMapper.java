package com.cigt.mapper;

import com.cigt.dto.ActDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActMapper {
    @Select("select * from t_act where store_id = #{store_id}")
    List<ActDto> getActsList(@Param("store_id")int store_id);
}
