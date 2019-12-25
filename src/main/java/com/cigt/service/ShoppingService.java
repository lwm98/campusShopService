package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.GoodsDto;
import com.cigt.dto.ShoppingDto;
import com.cigt.dto.UserDto;
import com.cigt.mapper.ShoppingMapper;
import com.cigt.my_util.GetTime_util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private GetTime_util getTime_util;

    /**
     * 查询购物车信息事务
     * @param user_id
     * @return
     */
    public R allShoppingByUserId(int user_id){
        List<ShoppingDto> shoppingDtos = shoppingMapper.allShoppingByUserId(user_id);
        if(shoppingDtos != null){
            for(ShoppingDto shoppingDto:shoppingDtos) {
                GoodsDto goodsDtos = shoppingMapper.goodsById(shoppingDto.getGoods_id());
                shoppingDto.setGoodsDtos(goodsDtos);
            }
            return R.ok(shoppingDtos);
        }
           return R.error("购物车为空");
    }

    /**
     * 插入购物车事务
     */
    public R insertShopping(int goods_id,int number,String user_address, HttpServletRequest httpServletRequest){
        ShoppingDto shoppingDto = new ShoppingDto();
        shoppingDto.setCreated_at(getTime_util.GetNowTime_util());
        shoppingDto.setUpdated_at(getTime_util.GetNowTime_util());
        UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("USER");
        shoppingDto.setUser_id(userDto.getId());
        shoppingDto.setGoods_id(goods_id);
        shoppingDto.setNumber(number);
        shoppingDto.setUser_address(user_address);
        try {
            shoppingMapper.insertShopping(shoppingDto);
            return R.ok("加入购物车成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("加入购物车失败");
        }
    }

    /**
     * 删除购物车事务
     * @param id
     * @return
     */
    public R deleteShopping(int id){
        try {
        shoppingMapper.deleteShopping(id);
        return R.ok("移除购物车成功");
        }catch (Exception e){
        System.out.println(e);
        return R.error("移除购物车失败");
         }
    }

    /**
     * 修改购物车事务
     */
    public R updateShopping(int id,int number,String user_address){
      String update_time = getTime_util.GetNowTime_util();
        try {
            shoppingMapper.updateShopping(id,number,user_address,update_time);
            return R.ok("修改成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("修改失败");
        }
    }

    /**
     * 查看订单事务
     */
    public R allOrderByUserId(int user_id){
        List<ShoppingDto> shoppingDto = shoppingMapper.allOrderByUserId(user_id);
        if(shoppingDto != null){
            return R.ok(shoppingDto);
        }
        return R.error("订单为空");
    }

    /**
     * 支付成功事务
     */
    public R successPay(int id){
        String updated_at = getTime_util.GetNowTime_util();
        try {
            shoppingMapper.successPay(id,updated_at);
            return R.ok("支付成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("支付失败");
        }
    }
}
