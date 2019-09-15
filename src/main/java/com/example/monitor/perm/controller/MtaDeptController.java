package com.example.monitor.perm.controller;


import com.example.monitor.perm.entity.MtaDept;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.monitor.controller.BaseController;

/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@RestController
@RequestMapping("/perm/mta-dept")
public class MtaDeptController extends BaseController<MtaDept> {

}

