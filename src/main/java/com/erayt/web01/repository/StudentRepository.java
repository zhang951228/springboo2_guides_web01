package com.erayt.web01.repository;

import com.erayt.web01.domain.Student;

/**
 * @Auther: Z151
 * @Date: 2021/8/25 18:26
 */
public interface StudentRepository {

    Student findStudentById(Long id);
}
