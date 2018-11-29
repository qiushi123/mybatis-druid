package com.example.demo.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by qcl on 2018/11/16
 * desc:
 */
@Entity
@Data
public class UserTest {
    @Id
    @GeneratedValue
    private int id;

    private int age;
    private String name;
}
