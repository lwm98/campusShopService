package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.StoreDto;
import com.cigt.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;

    public R getAllStore(int id){
        List<StoreDto> storeDtos = storeMapper.getAllStore(id);
        if(storeDtos != null){
            return R.ok(storeDtos);
        }
        else {
            return R.error("商铺为空");
        }
    }

}
