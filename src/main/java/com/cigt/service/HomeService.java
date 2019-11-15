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
    public List getLoadmMoreGoods(int currIndex){
        currIndex = (currIndex-1)*16;
        List<GoodsDto> ls = goodsMapper.getLoadmMoreGoods(currIndex,16);
        return ls;
    }
    /**
     * 依靠类别搜索商品
     */
    public List getGoodsByCategory(String category){
        List<GoodsDto> ls = goodsMapper.findGoodsByCategory(category);
        return ls;
    }
    /**
     * 获取商品类别
     */
    public List getGoodsCategory(){
        List ls =goodsMapper.findAllCategory();
        return ls;
    }
    /**
     * 模糊查询商品
     */
    public List findGoodsByName(String name){
        List ls =goodsMapper.findGoodsByName(name);
        return ls;
    }
}
