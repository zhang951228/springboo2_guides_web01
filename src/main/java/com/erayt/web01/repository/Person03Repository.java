package com.erayt.web01.repository;

import com.erayt.web01.domain.Person03;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/24 16:12
 */
//没理解，需要再看
    //path: 访问地址：

@RepositoryRestResource(collectionResourceRel = "people03", path = "people13")
public interface Person03Repository extends PagingAndSortingRepository<Person03,Long> {
    //访问地址： http://localhost:8081/people13/search/findByLastName?name=Las
    //guides地址：https://spring.io/guides/gs/accessing-data-rest/
    List<Person03> findByLastName(@Param("name") String name);

}

