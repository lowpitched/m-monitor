package com.example.monitor.perm.entity;

import com.example.monitor.common.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 模块表
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MtaModule extends BasePojo {

    private static final long serialVersionUID=1L;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 模块代码
     */
    private String moduleCode;

    /**
     * 模块描述
     */
    private String moduleDesc;

    /**
     * 父模块
     */
    private String modelParent;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private LocalDateTime ceateTime;

    /**
     * 修改时间
     */
    private LocalDateTime moidifyTime;


}
