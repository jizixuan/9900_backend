package com.proj.post_reply_demo.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "post")
public class Post implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String content;
    private String photo;
    private Long userId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;

    private static final long serialVersionUID = 1L;
}
