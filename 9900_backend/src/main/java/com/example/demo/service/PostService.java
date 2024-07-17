package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.domain.Post;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zixuan
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate
 */
public interface PostService extends IService<Post> {
    /**
     * 添加帖子
     * @param post
     * @return post的id
     */
    Long addPost(Post post, HttpServletRequest request);

    /**
     * 检查帖子是否非法，若非法则直接抛出异常
     * @param post
     */
    void validPost(Post post);
}