package com.cigt.service;

import com.cigt.dto.GoodsDto;
import com.cigt.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主页事务逻辑
 */
@Service
public class HomeService {
    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 获取所有商品信息
     */
    public List getAllGoods(){
        List<GoodsDto> ls = goodsMapper.getAllGoods();
        return ls;
    }
}
