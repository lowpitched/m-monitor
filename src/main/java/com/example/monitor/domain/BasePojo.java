package com.example.monitor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class BasePojo {
    @TableId(value = "id",type= IdType.ID_WORKER)
    private Long id;

}
