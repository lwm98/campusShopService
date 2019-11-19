package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 评论控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
@Api(tags = "评论接口")
public class CommentController {
    @Autowired
    private CommentService commentService;
    /**
     * 获取评论
     */
    @PostMapping("/getCommentInfo")
    @ApiOperation("获取商品评论")
    public R getCommentInfo(int goods_id){
        return commentService.getComment(goods_id);
    }

    /**
     * 发表评论
     */
    @PostMapping("/sendCommentInfo")
    @ApiOperation("发表评论")
    public R sendCommentInfo(int goods_id,
                             String content,
                             @RequestParam(required = false,defaultValue = "0") int pid,
                             @RequestParam(required = false,defaultValue = "0") int reply_id,
                             HttpServletRequest httpServletRequest){
        return commentService.sendComment(goods_id,content,reply_id,pid,httpServletRequest);
    }
}
