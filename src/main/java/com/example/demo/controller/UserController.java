package com.example.demo.controller;


import com.example.demo.aop.Timer;
import com.example.demo.service.UserTest2Service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by qcl on 2018/11/16
 * desc:
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    UserRepository repository;
    @Resource
    UserTest2Service service;

    @RequestMapping("/one")
    @ResponseBody
    @Timer(param = "我是传的参数")
    public List test() {
        return service.findAllList();
    }

}
