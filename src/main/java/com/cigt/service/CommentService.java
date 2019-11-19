package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.CommentDto;
import com.cigt.dto.CommentExt;
import com.cigt.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论事务层
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    /**
     * 处理某个商品的评论
     */
    public R getComment(int goods_id){
        try {
            List<CommentDto> commentDtos = commentMapper.findCommentById(goods_id);
            if(commentDtos==null){
                return R.ok("没有评论");
            }
            //遍历获取子评论及其内容
            for(CommentDto commentDto:commentDtos){
                List<CommentExt> commentExts = commentMapper.getCommentSons(commentDto.getId(),goods_id);
                commentDto.setCommentExts(commentExts);
            }
            return R.ok(commentDtos);
        }catch (Exception e){
            return R.error("操作数据库失败");
        }

    }
}
