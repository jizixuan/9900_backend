package com.proj.post_reply_demo.Service;


import com.proj.post_reply_demo.model.domain.Post;
import java.util.List;

public interface PostService {
    void createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    List<Post> getPostsByUserId(Long userId);
}
