package com.example.demo.service;

import com.example.demo.mapper.UserTestMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by qcl on 2018/11/16
 * desc:
 */
@Service
public class UserTestService {
    @Resource
    UserTestMapper mapper;

}
