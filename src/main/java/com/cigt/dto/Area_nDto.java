package com.cigt.dto;

import lombok.Data;

/**
 * 二级商区
 */
@Data
public class Area_nDto {
    private int id;
    private String name;
    private int pid; // 所属父id
    private int area_id; // 所属祖先id
}
