package com.erayt.web01.repository;

import com.erayt.web01.domain.PersonMongoDb04;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/25 16:35
 */
@RepositoryRestResource(collectionResourceRel = "mongodbpeople01", path = "mongodbpeople01")
public interface PersonMongoDb04Repository  extends MongoRepository<PersonMongoDb04,String> {

    List<PersonMongoDb04> findByLastName(@Param("name") String name);

}
