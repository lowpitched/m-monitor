drop table if exists mta_user;
create table mta_user(
	`id` bigint primary key auto_increment comment '主键',
	`pin` varchar(64) not null comment '登录名',
	`password` varchar(32) not null comment '密码',
	`nick_name` nvarchar(50) default null comment '昵称',
	`full_name` nvarchar(30) default null comment '真是姓名',
	`phone` varchar(12) default null comment '电话',
	`email` varchar(32) not null comment '邮箱',
	`dept` varchar(32) not null comment '部门',
	`status` varchar(3) default '1' comment '状态',
	`remark` nvarchar(100) default null comment '备注',
	`last_login_ip` varchar(15) default null comment '最后登录IP',
	`last_login_time` datetime default null comment '最后登录时间',
	`login_count` int default 0 comment '登录次数',
	`create_time` datetime default null comment '创建时间',
	`modify_time` timestamp default current_timestamp comment '修改时间',
	`delete` varchar(1) default '0' comment '删除表示'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE mta_permission;;/*SkipError*/
CREATE TABLE mta_permission(
    id BIGINT NOT NULL   COMMENT '主键' ,
    perm_code VARCHAR(32)    COMMENT '权限码' ,
    perm_name VARCHAR(64)    COMMENT '权限名称' ,
    perm_desc VARCHAR(128)    COMMENT '权限描述' ,
    remarks VARCHAR(512)    COMMENT '备注' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    moidify_time DATETIME    COMMENT '修改时间' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    creator VARCHAR(32)    COMMENT '创建人' ,
    editor VARCHAR(32)    COMMENT '修改人' ,
    PRIMARY KEY (id)
) COMMENT = '权限表 权限表';;

ALTER TABLE mta_permission COMMENT '权限表';;
DROP TABLE mta_module;;/*SkipError*/
CREATE TABLE mta_module(
    id BIGINT NOT NULL   COMMENT '主键 id' ,
    module_name VARCHAR(64)    COMMENT '模块名称' ,
    module_code VARCHAR(64)    COMMENT '模块代码' ,
    module_desc VARCHAR(512)    COMMENT '模块描述' ,
    model_parent VARCHAR(64)    COMMENT '父模块' ,
    remarks VARCHAR(512)    COMMENT '备注' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    moidify_time DATETIME    COMMENT '修改时间' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    creator VARCHAR(64)    COMMENT '创建人' ,
    editor VARCHAR(32)    COMMENT '修改人' ,
    PRIMARY KEY (id)
) COMMENT = '模块表 ';;

ALTER TABLE mta_module COMMENT '模块表';;
DROP TABLE mta_dept;;/*SkipError*/
CREATE TABLE mta_dept(
    id BIGINT NOT NULL   COMMENT '主键' ,
    dept_code VARCHAR(64)    COMMENT '部门代码' ,
    dept_name VARCHAR(128)    COMMENT '部门名称' ,
    dept_desc VARCHAR(512)    COMMENT '部门描述' ,
    dept_type VARCHAR(1)    COMMENT '部门类型' ,
    dept_parent VARCHAR(64)    COMMENT '父部门' ,
    remarks VARCHAR(512)    COMMENT '备注' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    moidify_time DATETIME    COMMENT '修改时间' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    createor VARCHAR(64)    COMMENT '创建人' ,
    editor VARCHAR(64)    COMMENT '修改人' ,
    PRIMARY KEY (id)
) COMMENT = '组织机构表 ';;

ALTER TABLE mta_dept COMMENT '组织机构表';;
DROP TABLE mta_role;;/*SkipError*/
CREATE TABLE mta_role(
    id BIGINT    COMMENT '主键' ,
    role_code VARCHAR(64)    COMMENT '角色代码' ,
    role_name VARCHAR(128)    COMMENT '角色名称' ,
    role_desc VARCHAR(512)    COMMENT '角色描述' ,
    role_type VARCHAR(1)    COMMENT '角色类型' ,
    remarks VARCHAR(512)    COMMENT '备注' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    moidify_time DATETIME    COMMENT '修改时间' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    createor VARCHAR(64)    COMMENT '创建人' ,
    editor VARCHAR(64)    COMMENT '修改人'
) COMMENT = '角色表 ';;

ALTER TABLE mta_role COMMENT '角色表';;
DROP TABLE mta_user_role;;/*SkipError*/
CREATE TABLE mta_user_role(
    id BIGINT NOT NULL   COMMENT '主键' ,
    user_id BIGINT    COMMENT '用户ID' ,
    role_id BIGINT    COMMENT '角色ID' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    moidify_time DATETIME    COMMENT '修改时间' ,
    createor VARCHAR(64)    COMMENT '创建人' ,
    editor VARCHAR(64)    COMMENT '修改人' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
) COMMENT = '用户角色表 ';;

ALTER TABLE mta_user_role COMMENT '用户角色表';;
DROP TABLE mta_permission_role;;/*SkipError*/
CREATE TABLE mta_permission_role(
    id BIGINT NOT NULL   COMMENT '主键' ,
    perm_id BIGINT    COMMENT '权限ID' ,
    role_id BIGINT    COMMENT '角色ID' ,
    createor VARCHAR(32)    COMMENT '创建人' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    editor VARCHAR(32)    COMMENT '更新人' ,
    moidify_time DATETIME    COMMENT '更新时间' ,
    DELETED VARCHAR(1)    COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
) COMMENT = '角色权限表 ';;

ALTER TABLE mta_permission_role COMMENT '角色权限表';;
DROP TABLE mta_module_role;;/*SkipError*/
CREATE TABLE mta_module_role(
    id BIGINT NOT NULL   COMMENT '主键' ,
    module_id BIGINT    COMMENT '模块ID' ,
    role_id BIGINT    COMMENT '角色ID' ,
    createor VARCHAR(32)    COMMENT '创建人' ,
    ceate_time DATETIME    COMMENT '创建时间' ,
    editor VARCHAR(32)    COMMENT '更新人' ,
    moidify_time DATETIME    COMMENT '更新时间' ,
    deleted VARCHAR(1)    COMMENT '逻辑删除' ,
    PRIMARY KEY (id)
) COMMENT = '角色模块表 ';;

ALTER TABLE mta_module_role COMMENT '角色模块表';;
