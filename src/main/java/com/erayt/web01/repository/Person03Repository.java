package com.erayt.web01.repository;

import com.erayt.web01.domain.Person;
import com.erayt.web01.domain.Person03;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/24 16:12
 */
public interface Person03Repository extends PagingAndSortingRepository<Person03,Long> {

    List<Person03> findByLastName(String name);

}

