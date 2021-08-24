package com.erayt.web01.domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: Z151
 * @Date: 2021/8/24 16:10
 */
@Data
@ToString
@Slf4j
@Entity
public class Person03 {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
}
