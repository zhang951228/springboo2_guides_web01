package com.erayt.web01.domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

/**
 * @Auther: Z151
 * @Date: 2021/8/23 17:55
 */
@ToString
@Slf4j
@Data
public class Customer {

    @Id
    public String id;

    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
