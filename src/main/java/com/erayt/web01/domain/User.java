package com.erayt.web01.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录用户基础信息 对应数据表（t_user）
 * @Auther: Z151
 * @Date: 2021/4/1 11:53
 */
@ToString
@Data
@EqualsAndHashCode
@TableName("td_user")
public class User implements Serializable {

    private static final Long  serialVersionUID = 23L;

    private Integer sequence;
    @Id
    private String userName;
    private String password;
    private String rule;
    private Date lastLogin;
    private Date overdueTime;
    private String state;
}
