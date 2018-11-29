package com.example.demo.service;

import com.example.demo.controller.UserTest;
import com.example.demo.mapper.UserTestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTest2Service {
    @Autowired
    private UserTestMapper mapper;

    public List<UserTest> findAllList() {
        return mapper.findAllList();
    }
}
