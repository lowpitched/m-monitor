package com.example.monitor.perm.controller;


import com.example.monitor.perm.entity.MtaUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.example.monitor.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mlh
 * @since 2019-09-13
 */
@RestController
@RequestMapping("/api/perm/mtaUser")
public class MtaUserController extends BaseController<MtaUser> {

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

}

