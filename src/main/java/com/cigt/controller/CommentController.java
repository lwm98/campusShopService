package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评论控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;
    /**
     * 获取评论
     */
    @PostMapping("/getCommentInfo")
    public R getCommentInfo(int goodsId){
        return commentService.getComment(goodsId);
    }

}
