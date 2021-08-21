package com.erayt.web01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erayt.web01.domain.User;
import com.erayt.web01.repository.UserMapper;
import com.erayt.web01.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/18 11:19
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User>  implements UserService{

    @Autowired
    private UserMapper userMapper;

    public User getUserByUserName(String userName){
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public List<User> selectList(){
        return userMapper.selectList(null);

    }

    @Override
    public List<User> findAll() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public Integer insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }
}
