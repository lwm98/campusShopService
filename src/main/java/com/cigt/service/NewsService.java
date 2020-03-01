package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.NewsDto;
import com.cigt.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsMapper newsMapper;

    public R getNews(int id){
        NewsDto newsList = newsMapper.getNews(id);
        return R.ok(newsList);
    }

    public R getNewsList(int store_id){
        List<NewsDto> newsDto = newsMapper.getNewsList(store_id);
        return R.ok(newsDto);
    }
}
