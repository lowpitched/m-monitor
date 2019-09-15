package com.example.monitor.perm.entity;

import com.example.monitor.anotation.query.DoWrapper;
import com.example.monitor.common.BasePojo;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class MtaUser extends BasePojo {

    @DoWrapper(wrapperIgnore = true)
    private static final long serialVersionUID=1L;

    /**
     * 登录名
     */
    @DoWrapper(rawColumn = "pin")
    private String pin;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真是姓名
     */
    private String fullName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门
     */
    private String dept;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 登录次数
     */
    private Integer loginCount;


}
