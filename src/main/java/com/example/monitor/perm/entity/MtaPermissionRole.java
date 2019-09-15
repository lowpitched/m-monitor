package com.example.monitor.perm.entity;

import com.example.monitor.common.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MtaPermissionRole extends BasePojo {

    private static final long serialVersionUID=1L;

    /**
     * 权限ID
     */
    private Long permId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 创建人
     */
    private String createor;

    /**
     * 创建时间
     */
    private LocalDateTime ceateTime;

    /**
     * 更新时间
     */
    private LocalDateTime moidifyTime;


}
