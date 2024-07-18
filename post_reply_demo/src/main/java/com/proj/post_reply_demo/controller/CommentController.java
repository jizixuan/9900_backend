package com.proj.post_reply_demo.controller;

import com.proj.post_reply_demo.Service.CommentService;
import com.proj.post_reply_demo.model.domain.Comment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
@Tag(name = "Comment Management", description = "APIs for managing comment")
public class CommentController {
    private static final Logger log = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    @PostMapping
    @Operation(summary = "Create a new comment")
    public ResponseEntity<Comment> createComment(@PathVariable Long postId, @RequestBody Comment comment) {
        comment.setPostId(postId);
        commentService.createComment(comment);
        log.info(comment.getContent()+"create by"+comment.getUserId());
        return ResponseEntity.ok(comment);
    }

    @GetMapping
    @Operation(summary = "get comment by post id")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }
}

