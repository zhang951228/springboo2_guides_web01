package com.erayt.web01.repository;

import com.erayt.web01.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Z151
 * @Date: 2021/4/1 13:37
 */

@Mapper
public interface UserMapper {

    User selectByAccount(String account);

    User getUserByUserName(String name);
}
