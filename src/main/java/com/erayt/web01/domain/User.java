package com.erayt.web01.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


/**
 * 登录用户基础信息 对应数据表（t_user）
 * @Auther: Z151
 * @Date: 2021/4/1 11:53
 */
@ToString
@Data
@EqualsAndHashCode
public class User {
    /** 顺序号 **/
    private Integer id;
    /** 用户账户 **/
    private String name;

    private String love;
}
