package com.cigt.dto;

import lombok.Data;

@Data
public class NewsDto {
    private int id;
    private int userId;
    private int store_id;
    private String title;
    private String desc;
    private String img;
    private int watch;
    private int comments;
    private String created_at;
}
