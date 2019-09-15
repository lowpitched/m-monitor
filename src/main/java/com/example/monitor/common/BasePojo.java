package com.example.monitor.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors
@Getter
@Setter
public class BasePojo {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String creator;

    private String editor;

    private Date createTime;
    //创建时间大于等于
    @TableField(exist = false)
    private Date createTime_GE;
    //创建时间小于等于
    @TableField(exist = false)
    private Date createTime_LE;

    private Date modifyTime;
    @TableLogic
    private String deleted;

}
