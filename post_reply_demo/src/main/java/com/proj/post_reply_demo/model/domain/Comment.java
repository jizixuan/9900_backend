package com.proj.post_reply_demo.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "comment")
public class Comment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long postId;
    private String content;
    private Long userId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
