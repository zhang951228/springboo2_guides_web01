package com.erayt.web01.controller;

import com.erayt.web01.domain.User;
import com.erayt.web01.repository.UserMapper;
import com.erayt.web01.service.iface.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

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

    @Async
    @GetMapping("/hello1")
    public String seHello(@RequestParam(value = "name1",defaultValue = "World123") String name, String password){
        String logStr = String.format("调用seHello, 传入参数  %s!   %s!",name,password);
        System.out.println(logStr);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(logStr);
        return  logStr;
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.selectList();
        log.info("调用 findAll ");
        return users;
    }

    @GetMapping("/find")
    public User findAll2(@RequestParam (value = "account",defaultValue = "")String account){
        User user = userService.getUserByUserName(account);
        log.info( HtmlUtils.htmlEscape("调用 findAll2 "));
        return user;
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

    @Transactional
    @GetMapping("/insert2")
    public Integer insertUser2(@RequestParam(value = "name",defaultValue = "啊啊啊") String name){
        User user = new User();
        user.setUserName(name);
        user.setRule("RULE");
        user.setPassword("1234545");
        Integer insert = userService.insert(user);
        insert = userService.insert(user);
        insert = userService.insert(user);
        return insert;
    }

}
