package com.cigt.dto;

import lombok.Data;

/**
 * 评论扩展类
 */
@Data
public class CommentExt {
    private int user_id;
    private String content;
    private String create_time;
    private String image;
    private String real_name;
    private int reply_id;
    private String reply_image;
    private String reply_real_name;
}
