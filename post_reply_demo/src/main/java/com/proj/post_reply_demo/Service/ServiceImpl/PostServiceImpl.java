package com.proj.post_reply_demo.Service.ServiceImpl;


import com.proj.post_reply_demo.Service.PostService;
import com.proj.post_reply_demo.mapper.PostMapper;
import com.proj.post_reply_demo.model.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public void createPost(Post post) {
        postMapper.insert(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postMapper.selectList(null);
    }

    @Override
    public Post getPostById(Long id) {
        return postMapper.selectById(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postMapper.selectPostsByUserId(userId);
    }
}
