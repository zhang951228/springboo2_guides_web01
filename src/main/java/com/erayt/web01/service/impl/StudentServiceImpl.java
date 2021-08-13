package com.erayt.web01.service.impl;

import com.erayt.web01.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Z151
 * @Date: 2021/8/12 18:01
 */
@Service
public class StudentServiceImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;



    public String findStudent(long id){
        System.out.println(this.getClass().getSimpleName()+".findStudent"+id);
        jdbcTemplate.execute("create table STUDENT\n" +
            "(\n" +
            "  id varchar2(100),\n" +
            "  name varchar2(100),\n" +
            "  clz varchar2(100)\n" +
            ")");
        List<Object[]> collect = Arrays.asList("1 张三 1班", "2 张三2 2班", "3 张三3 3班", "4 张三4 4班").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList());
        collect.forEach(name -> System.out.println(String.format("Inserting STUDENT record for %s %s %s", name[0], name[1],name[2])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO STUDENT(id, name,clz) VALUES (?,?,?)", collect);
        System.out.println("Querying for customer records where first_name = '1':");

        jdbcTemplate.query(
            "SELECT id, name, clz FROM STUDENT WHERE id = ?", new Object[] { "1" },
            (rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("name"), rs.getString("clz"))
        ).forEach(customer -> System.out.println(customer.toString()));

        return null;
    }
}
