package com.cigt.dto;

import lombok.Data;

/**
 * 商铺
 */
@Data
public class StoreDto {
    private int id;
    private int pid;
    private int area_id;
    private String name;
    private String date;
    private String desc;
    private String tel;
    private String contact;
    private String address;
    private String serviceTime;
    private String notice;
    private int comments;
    private String banner1;
    private String banner2;
    private String banner3;
    private String banner4;
    private String banner5;
    private String menu1;
    private String menu2;
    private String menu3;
    private String voucher1;
    private String voucher2;
    private String voucher3;
    private int status;
    private String showImg;
}
