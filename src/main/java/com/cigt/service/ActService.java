package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.ActDto;
import com.cigt.mapper.ActMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActService {
    @Autowired
    private ActMapper actMapper;

    public R getActsList(int store_id){
        List<ActDto> actDto = actMapper.getActsList(store_id);
        return R.ok(actDto);
    }
}
