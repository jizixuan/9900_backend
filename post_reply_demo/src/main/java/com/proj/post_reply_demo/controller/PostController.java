package com.proj.post_reply_demo.controller;

import com.proj.post_reply_demo.Service.PostService;
import com.proj.post_reply_demo.model.domain.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Tag(name = "Post Management", description = "APIs for managing posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    @Operation(summary = "Create a new post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postService.createPost(post);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    @Operation(summary = "getAllPosts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "get post by id")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "get post by user id")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }
}
