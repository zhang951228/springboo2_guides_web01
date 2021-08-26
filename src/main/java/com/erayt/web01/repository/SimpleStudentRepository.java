package com.erayt.web01.repository;

import com.erayt.web01.domain.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Auther: Z151
 * @Date: 2021/8/26 10:02
 */
@Component
@Cacheable("stu")
public class SimpleStudentRepository implements  StudentRepository {
    public Student findStudentById(Long id) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Student student = new Student(1,"nAmu","clz");
        return student;
    }

}
