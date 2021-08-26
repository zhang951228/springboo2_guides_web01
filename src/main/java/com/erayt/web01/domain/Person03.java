package com.erayt.web01.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @Auther: Z151
 * @Date: 2021/8/24 16:10
 */
@Data
@ToString
@Slf4j
@Entity
@TableName("Person03")
public class Person03 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;
    private String firstName;
    private String lastName;

    public Person03(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person03() {
    }
}
