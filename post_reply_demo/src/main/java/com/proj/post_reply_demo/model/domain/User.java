package com.proj.post_reply_demo.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "user")
public class User implements Serializable {
    /**
     * 用户 ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户角色
     */
    private Integer userRole;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * zID
     */
    private String zID;

    /**
     * 组名
     */
    private String groupName;

    /**
     * 偏好
     */
    private String preference;

    /**
     * 公司
     */
    private String company;

    /**
     * 职位
     */
    private String jobTitle;

    /**
     * 头像 URL
     */
    private String avatarUrl;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
