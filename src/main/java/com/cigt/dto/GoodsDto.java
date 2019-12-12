package com.cigt.dto;

import lombok.Data;

/**
 * 商品实体类
 */
@Data
public class GoodsDto {
    private int id;
    private String name;
    private String depict;
    private double price;
    private String images;
    private String time;
    private String updated_at;
    private int user_id;
    private int num;
    private String category;
}
