package com.erayt.web01.controller;

import com.erayt.web01.domain.User;
import com.erayt.web01.repository.UserMapper;
import com.erayt.web01.service.iface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/21 10:44
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/selectList")
    public List<User> selectList(){
        List<User> users = userService.selectList();
        log.info("调用selectList ");
        return users;
    }
}
