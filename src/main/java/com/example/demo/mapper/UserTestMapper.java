package com.example.demo.mapper;

import com.example.demo.controller.UserTest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTestMapper {

    @Select("select * from user_test")
    List<UserTest> findAllList();
}
