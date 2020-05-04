package com.cigt.mapper;

import com.cigt.dto.NewsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select * from t_news where id = #{id}")
    NewsDto getNews(@Param("id")int id);

    @Select("select * from t_news where store_id = #{store_id}")
    List<NewsDto> getNewsList(@Param("store_id")int store_id);


    @Select("SELECT * from t_news t\n" +
            "join t_user tu on t.userId = tu.id join t_store on t_store.id = t.store_id")
    List<NewsDto> getAllNewsList();
}
