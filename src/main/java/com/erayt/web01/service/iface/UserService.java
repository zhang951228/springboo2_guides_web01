package com.erayt.web01.service.iface;

import com.erayt.web01.domain.User;

/**
 * @Auther: Z151
 * @Date: 2021/8/18 11:19
 */
public interface UserService {
    User getUserByUserName(String account);
}
