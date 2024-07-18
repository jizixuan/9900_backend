package com.proj.post_reply_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.post_reply_demo.model.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("SELECT * FROM comment WHERE post_id = #{postId}")
    List<Comment> selectCommentsByPostId(Long postId);
}
