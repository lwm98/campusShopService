package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.NewsDto;
import com.cigt.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewService {

    @Autowired
    private AreaMapper areaMapper;

    public R findNewsById(int id){
        NewsDto newsDto = areaMapper.findNewById(id);
        if(newsDto != null){
            return R.ok(newsDto);
        }else {
            return R.error("新闻不存在");
        }
    }
}
