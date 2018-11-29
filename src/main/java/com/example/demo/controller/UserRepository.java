package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by qcl on 2018/11/16
 * desc:
 */
public interface UserRepository extends JpaRepository<UserTest, Integer> {
}
