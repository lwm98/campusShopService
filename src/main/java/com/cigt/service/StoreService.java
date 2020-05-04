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

    public R getAllStore(){
        List<StoreDto> storeDtos = storeMapper.getAllStore();
        if(storeDtos != null){
            return R.ok(storeDtos);
        }
        else {
            return R.error("商铺为空");
        }
    }

    public R getStoreByArea(int id){
        List<StoreDto> storeDtos = storeMapper.getStoreByArea(id);
        if (storeDtos != null){
            return R.ok(storeDtos);
        }else {
            return R.error("该地区暂无商铺");
        }
    }

    public R getStoreByid(int id){
        List<StoreDto> storeDtos = storeMapper.getStoreByid(id);
        if (storeDtos != null){
            return R.ok(storeDtos);
        }else {
            return R.error("暂无信息");
        }
    }


    public R getAllStoreList(){
        List<StoreDto> storeDtos = storeMapper.getAllStoreList();
        return R.ok(storeDtos);
    }


    public R getAllzlStore(){
        List<StoreDto> storeDtos = storeMapper.getAllzlStore();
        return R.ok(storeDtos);
    }
    public R getAllwzlStore(){
        List<StoreDto> storeDtos = storeMapper.getAllwzlStore();
        return R.ok(storeDtos);
    }

}
