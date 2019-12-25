package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dao.GoodsDAO;
import com.cigt.dto.GoodsDto;
import com.cigt.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页事务逻辑
 */
@Service
@Transactional
public class HomeService {
    @Autowired
    private GoodsDAO goodsDAO;
    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 分页获取商品信息
     * @param category
     * @param pageNum
     * @return
     */
    public R getLoadmMoreGoods(int category, int pageNum){
        //计算从第几条开始
        pageNum = (pageNum-1)*8;

        List<List<?>> ls = goodsDAO.getLoadmMoreGoods(category, pageNum);

        Map map = new HashMap();
        map.put("goods",ls.get(0));
        map.put("goodsNum",ls.get(1).get(0));
        return R.ok(map);
    }
//    /**
//     * 依靠类别搜索商品
//     */
//    public List getGoodsByCategory(String category){
//        List<GoodsDto> ls = goodsMapper.findGoodsByCategory(category);
//        return ls;
//    }
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
