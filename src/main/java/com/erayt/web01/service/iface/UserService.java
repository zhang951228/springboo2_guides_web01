package com.erayt.web01.service.iface;

import com.baomidou.mybatisplus.extension.service.IService;
import com.erayt.web01.domain.User;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/18 11:19
 */
public interface UserService extends IService<User> {
    User getUserByUserName(String account);

    List<User> selectList ();

    List<User> findAll();

    Integer insert(User user);
}
