package com.cigt.mapper;

import com.cigt.dto.AreaDto;
import com.cigt.dto.NewsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AreaMapper {

    /**
     * 次数加1
     */
    @Update("update t_area set clicks = clicks + 1  where id = #{id}")
    int clicksAdd(@Param("id") int id);

    /**
     * 根据ID查询新闻
     */
    @Select("select * from t_news where id = #{id}")
    NewsDto findNewById(@Param("id")int id);

    /**
     * 查询所有地区信息
     */
    @Select("select * from t_area")
    List<AreaDto> getArea();
}
