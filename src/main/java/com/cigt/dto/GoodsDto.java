package com.cigt.dto;

import lombok.Data;

/**
 * 商品实体类
 */
@Data
public class GoodsDto {
    private int goods_id;
    private String goods_name;
    private double goods_price;
    private String goods_images;
    private String goods_time;
    private String updated_at;
    private int user_id;
    private int goods_num;
    private String goods_category;
}
