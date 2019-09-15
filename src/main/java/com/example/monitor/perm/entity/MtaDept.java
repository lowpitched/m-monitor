package com.example.monitor.perm.entity;

import com.example.monitor.common.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MtaDept extends BasePojo {

    private static final long serialVersionUID=1L;

    /**
     * 部门代码
     */
    private String deptCode;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门描述
     */
    private String deptDesc;

    /**
     * 部门类型
     */
    private String deptType;

    /**
     * 父部门
     */
    private String deptParent;

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

    /**
     * 创建人
     */
    private String createor;


}
