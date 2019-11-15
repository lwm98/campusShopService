package com.cigt.dto;

import lombok.Data;

/**
 * 购物车实体类
 */
@Data
public class ShoppingDto {
    private int id;
    private int goods_id;
    private int user_id;
    private int number;
}
