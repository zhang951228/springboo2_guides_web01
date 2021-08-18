package com.erayt.web01.repository;

import com.erayt.web01.domain.Person;
import com.erayt.web01.domain.Person02;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

/**
 * @Auther: Z151
 * @Date: 2021/8/18 17:04
 */

public interface  PersonRepository extends CrudRepository<Person02,String> {
    @Trace
    Person02 findByName(String name);

    @Trace
    Iterable<Person02> findByAgeGreaterThan(int age);

    @Trace
    Iterable<Person02> findByAgeLessThan(int age);

    @Trace
    Iterable<Person02> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);
}
