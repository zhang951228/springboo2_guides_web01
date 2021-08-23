package com.erayt.web01.repository;

import com.erayt.web01.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/23 17:57
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
