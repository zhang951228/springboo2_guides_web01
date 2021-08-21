package com.erayt.web01.controller;

import com.erayt.web01.domain.User;
import com.erayt.web01.repository.UserMapper;
import com.erayt.web01.service.iface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.selectList();
        log.info("调用 findAll ");
        return users;
    }

    @GetMapping("/insert")
    public Integer insertUser(@RequestParam(value = "name",defaultValue = "啊啊啊") String name){
        User user = new User();
        user.setUserName(name);
        user.setRule("RULE");
        user.setPassword("1234545");
        Integer insert = userService.insert(user);
        return insert;
    }

}
