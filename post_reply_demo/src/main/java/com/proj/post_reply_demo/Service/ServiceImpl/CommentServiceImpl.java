package com.proj.post_reply_demo.Service.ServiceImpl;

import com.proj.post_reply_demo.Service.CommentService;
import com.proj.post_reply_demo.mapper.CommentMapper;
import com.proj.post_reply_demo.model.domain.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void createComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }
}

