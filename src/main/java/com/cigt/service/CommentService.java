package com.cigt.service;

import com.cigt.base.R;
import com.cigt.dto.CommentDto;
import com.cigt.dto.CommentExt;
import com.cigt.dto.UserDto;
import com.cigt.mapper.CommentMapper;
import com.cigt.my_util.GetTime_util;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论事务层
 */
@Service
@Transactional
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private GetTime_util getTime_util;
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
    /**
     * 用户评论
     */
    public R sendComment(int goods_id, String content, int reply_id, int pid, HttpSession session){
        CommentDto commentDto =new CommentDto();
        //System.out.println(session.getAttribute("USER"));
        UserDto userDto = (UserDto)session.getAttribute("USER");
        commentDto.setGoods_id(goods_id);
        commentDto.setUser_id(userDto.getId());
        commentDto.setContent(content);
        commentDto.setCreate_time(getTime_util.GetNowTime_util());
        if(reply_id==0){
            commentDto.setType(0);
        }else {
            commentDto.setType(1);
            commentDto.setReply_user_id(reply_id);
        }
        commentDto.setPid(pid);
        try{
            commentMapper.insertComment(commentDto);
            return R.ok("评论成功");
        }catch (Exception e){
            System.out.println(e);
            return R.error("评论失败");
        }
    }
}
