package com.example.monitor.perm.controller;


import com.example.monitor.perm.entity.MtaPermission;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.monitor.controller.BaseController;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@RestController
@RequestMapping("/perm/mta-permission")
public class MtaPermissionController extends BaseController<MtaPermission> {

}

