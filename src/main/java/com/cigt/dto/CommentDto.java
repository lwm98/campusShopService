package com.cigt.dto;

import lombok.Data;

import java.util.List;


@Data
public class CommentDto {
    private int id;
    private String  name;
    private String real_name;
    private String sex;
    private String image;
    private int goods_id;
    private int user_id;
    private String content;
    private String create_time;
    private int type;
    private int reply_user_id;
    private int pid;
    //子评论
    private List<CommentExt> commentExts;

}
