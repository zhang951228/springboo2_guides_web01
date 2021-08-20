package com.erayt.web01.controller;

import com.erayt.web01.service.iface.ReadService;
import com.erayt.web01.service.iface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: Z151
 * @Date: 2021/8/20 10:15
 */
@Slf4j
@RestController
@RequestMapping("/db")
public class DbMasterSlaverController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReadService readService;

    @GetMapping("/insert")
    public String insertData(){
        return "插入数据完毕 : insert data success";
    }

    @GetMapping("/find")
    public String findData(){
        readService.findBooks();
        userService.getUserByUserName("123456");
        return "find";
    }
}
