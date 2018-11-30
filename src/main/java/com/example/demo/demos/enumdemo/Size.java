package com.example.demo.demos.enumdemo;

import java.util.Arrays;

/**
 * Created by qcl on 2018/11/30
 * desc:枚举类
 */
public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");

    private String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Size.values()));
    }
}
