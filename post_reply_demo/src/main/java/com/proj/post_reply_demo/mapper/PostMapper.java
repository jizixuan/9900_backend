package com.proj.post_reply_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.proj.post_reply_demo.model.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<Post> {
    @Select("SELECT * FROM post WHERE user_id = #{userId}")
    List<Post> selectPostsByUserId(Long userId);
}
