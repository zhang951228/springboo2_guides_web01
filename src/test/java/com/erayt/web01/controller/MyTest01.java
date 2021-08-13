package com.erayt.web01.controller;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 13:43
 */
public class MyTest01 {

    public static void main(String[] args) {
        String[] strarr01 = new String[3];
        strarr01[0] = "0";
        strarr01[1] = "1";
        strarr01[2] = "2";
        String[] clone = strarr01.clone();
        System.out.println("clone[0]"+clone[0]);
        System.out.print("clone[1]"+clone[1]);
        System.out.print("clone[2]"+clone[2]);
        clone[2] = "3";

        System.out.println("clone[2]"+clone[2]);
        System.out.println("strarr01[2]"+strarr01[2]);


    }
}
