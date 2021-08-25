package com.erayt.web01.domain;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;


/**
 * @Auther: Z151
 * @Date: 2021/8/24 16:10
 */
@Data
@ToString
@Slf4j
public class PersonMongoDb04 {

    @Id private long id;
    private String firstName;
    private String lastName;
}
