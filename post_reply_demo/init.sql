-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS 9900proj;

-- 使用该数据库
USE 9900proj;

-- 删除表（如果存在）
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS project;

-- 创建 user 表
CREATE TABLE user (
                      id           bigint auto_increment         primary key,
                      userRole     int                                not null comment '0 - admin; 1 - tutor; 2 - client; 3 - student',
                      username     varchar(256)                       null,
                      email        varchar(512)                       not null,
                      userPassword varchar(512)                       not null,
                      zID          varchar(512)                       null,
                      groupName    varchar(256)                       null,
                      preference   varchar(1024)                      null comment 'list of project ID',
                      company      varchar(512)                       null,
                      jobTitle     varchar(512)                       null,
                      avatarUrl    varchar(1024)                      null,
                      createTime   datetime default CURRENT_TIMESTAMP null,
                      isDelete     tinyint  default 0                 not null
);

-- 创建 project 表
CREATE TABLE project (
                         projectID        bigint auto_increment         primary key,
                         projectName      varchar(512)                       null,
                         details          varchar(256)                       null,
                         projectOwner     bigint                             not null comment 'the ID of client who created it',
                         readyGroupIDList varchar(512)                       null comment 'IDList of those group who choosed this group as first reference',
                         finalGroupList   varchar(512)                       null comment 'those who are choosed finally',
                         createTime       datetime default CURRENT_TIMESTAMP null,
                         isDelete         tinyint  default 0                 not null
);
CREATE TABLE post (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
                      content TEXT NULL COMMENT '内容',
                      user_id BIGINT NOT NULL COMMENT '创建用户 id',
                      create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                      update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                      is_delete TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除',
                      FOREIGN KEY (user_id) REFERENCES user(id)
);
-- 创建 comment 表
CREATE TABLE comment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
                         post_id BIGINT NOT NULL COMMENT '帖子 id',
                         content TEXT NULL COMMENT '内容',
                         user_id BIGINT NOT NULL COMMENT '用户 id',
                         create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
                         update_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                         is_delete TINYINT DEFAULT 0 NOT NULL COMMENT '是否删除',
                         FOREIGN KEY (post_id) REFERENCES post(id),
                         FOREIGN KEY (user_id) REFERENCES user(id)
);

-- 插入 user 表测试数据
INSERT INTO user (userRole, username, email, userPassword, zID, groupName, preference, company, jobTitle, avatarUrl, createTime, isDelete)
VALUES
    (0, 'admin', 'admin@test.com', '123456', NULL, NULL, NULL, NULL, NULL, NULL, '2023-06-27 10:00:00', 0),
    (1, 'tutor1', 'tutor1@test.com', '123456', NULL, NULL, NULL, 'ABC University', NULL, NULL, '2023-06-27 11:00:00', 0),
    (1, 'tutor2', 'tutor2@test.com', '123456', NULL, NULL, NULL, 'DEF College', NULL, NULL, '2023-06-27 11:01:00', 0),
    (2, 'client1', 'client1@test.com', '123456', NULL, NULL, NULL, 'XYZ Company', 'Project Manager', NULL, '2023-06-27 12:00:00', 0),
    (2, 'client2', 'client2@test.com', '123456', NULL, NULL, NULL, 'WVU Corporation', 'Product Owner', NULL, '2023-06-27 12:01:00', 0),
    (3, 'student1', 'student1@test.com', '123456', 'z5555555', 'Group A', '1,2,3', NULL, NULL, NULL, '2023-06-27 13:00:00', 0),
    (3, 'student2', 'student2@test.com', '123456', 'z6666666', 'Group B', '2,3,4', NULL, NULL, NULL, '2023-06-27 13:01:00', 0),
    (3, 'student3', 'student3@test.com', '123456', 'z7777777', 'Group A', '1,3,5', NULL, NULL, NULL, '2023-06-27 13:02:00', 0),
    (3, 'student4', 'student4@test.com', '123456', 'z8888888', 'Group C', '4,5,6', NULL, NULL, NULL, '2023-06-27 13:03:00', 0);

-- 插入 project 表测试数据
INSERT INTO project (projectName, details, projectOwner, readyGroupIDList, finalGroupList, isDelete)
VALUES
    ('Project A', 'Details for Project A', 4, '1,2,3', '2', 0),
    ('Project B', 'Details for Project B', 5, '1,3,4', '4', 0),
    ('Project C', 'Details for Project C', 4, '2,4', '2,4', 0),
    ('Project D', 'Details for Project D', 5, '1,3', '3', 0),
    ('Project E', 'Details for Project E', 4, '2,3,4', '3,4', 0);




-- 插入 post 表测试数据
INSERT INTO post (content, user_id, create_time, update_time, is_delete)
VALUES
    ('This is the first post',1, '2023-06-27 14:00:00', '2023-06-27 14:00:00', 0),
    ('This is the second post',  2, '2023-06-27 14:30:00', '2023-06-27 14:30:00', 0),
    ('This is the third post',  3, '2023-06-27 15:00:00', '2023-06-27 15:00:00', 0),
    ('This is the fourth post',  4, '2023-06-27 15:30:00', '2023-06-27 15:30:00', 0),
    ('This is the fifth post',  5, '2023-06-27 16:00:00', '2023-06-27 16:00:00', 0);
-- 插入 comment 表测试数据
INSERT INTO comment (post_id, content, user_id, create_time, update_time, is_delete)
VALUES
    (1, 'This is a comment on the first post', 3, '2023-06-27 16:30:00', '2023-06-27 16:30:00', 0),
    (1, 'This is another comment on the first post', 4, '2023-06-27 17:00:00', '2023-06-27 17:00:00', 0),
    (2, 'This is a comment on the second post', 5, '2023-06-27 17:30:00', '2023-06-27 17:30:00', 0),
    (3, 'This is a comment on the third post', 1, '2023-06-27 18:00:00', '2023-06-27 18:00:00', 0),
    (4, 'This is a comment on the fourth post', 2, '2023-06-27 18:30:00', '2023-06-27 18:30:00', 0);
