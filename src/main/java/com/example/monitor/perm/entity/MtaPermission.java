package com.example.monitor.perm.entity;

import com.example.monitor.common.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MtaPermission extends BasePojo {

    private static final long serialVersionUID=1L;

    /**
     * 权限码
     */
    private String permCode;

    /**
     * 权限名称
     */
    private String permName;

    /**
     * 权限描述
     */
    private String permDesc;

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
