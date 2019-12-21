package com.cigt.controller;

import com.cigt.base.R;
import com.cigt.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 评论控制器
 */
@Controller
@ResponseBody
@RequestMapping("/api")
@Api(tags = "评论接口")
@CrossOrigin(origins = "*",maxAge = 3600)
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
                             HttpSession session){
        System.out.println("发表评论控制器"+session.getAttribute("USER"));
        return commentService.sendComment(goods_id,content,reply_id,pid,session);
    }
}
