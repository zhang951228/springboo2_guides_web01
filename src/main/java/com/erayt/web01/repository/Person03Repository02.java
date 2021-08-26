package com.erayt.web01.repository;

import com.erayt.web01.domain.Person03;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/26 14:02
 */
public interface Person03Repository02 extends JpaRepository<Person03,Long> {

    List<Person03> findByLastNameStartsWithIgnoreCase(String lastName);
}
