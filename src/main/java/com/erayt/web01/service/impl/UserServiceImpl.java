package com.erayt.web01.service.impl;

import com.erayt.web01.domain.User;
import com.erayt.web01.service.iface.UserService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Z151
 * @Date: 2021/8/18 11:19
 */

@Service
public class UserServiceImpl implements UserService {


    public User getUserByUserName(String account){
        return new User();
    }
}
