package com.proj.post_reply_demo.Service;

import com.proj.post_reply_demo.model.domain.Comment;

import java.util.List;

public interface CommentService {
    void createComment(Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
}