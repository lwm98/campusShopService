package com.cigt.mapper;

import com.cigt.dto.ShoppingDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    /**
     * 查询购物车信息
     */
    @Select("select ts.*,tg.name,tg.depict,tg.price,tg.images,tg.category,tg.status " +
            "from t_shopping ts " +
            "JOIN t_goods tg ON ts.goods_id=tg.id where ts.status=0 and ts.user_id=#{user_id} ")
    List<ShoppingDto> allShoppingByUserId(@Param("user_id") int user_id);

    /**
     * 插入购物车信息
     */
    @Insert("INSERT INTO t_shopping (goods_id,user_id,number,user_address,created_at,updated_at) " +
            "VALUES (#{goods_id},#{user_id},#{number},#{user_address},#{created_at},#{updated_at})")
    ShoppingDto insertShopping(ShoppingDto shoppingDto);

    /**
     * 删除购物车信息
     */
    @Delete("delete from t_shopping where id = #{id}")
    int deleteShopping(@Param("id")int id);

    /**
     * 修改购物车信息
     */
    @Update("update t_shopping SET number=#{number},user_address=#{user_address},updated_at=#{updated_at} where id = #{id}")
    int updateShopping(@Param("id") int id,
                       @Param("number") int number,
                       @Param("user_address") String user_address,
                       @Param("updated_at") String updated_at );

    /**
     * 查询订单信息
     */
    @Select("select ts.*,tg.name,tg.depict,tg.price,tg.images,tg.category " +
            "from t_shopping ts " +
            "JOIN t_goods tg ON ts.goods_id=tg.id where ts.status=1 and ts.user_id =#{user_id}")
    List<ShoppingDto> allOrderByUserId(@Param("user_id") int user_id);


    /**
     * 支付完成后修改购物车状态
     */
    @Update("update t_shopping SET status=1,updated_at=#{updated_at} where id = #{id}")
    int successPay(@Param("id")int id,
                   @Param("updated_at") String updated_at);

}
