package com.yuce.envanter.controller;

import com.yuce.envanter.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "userapi", path = "userapi")
public interface UserRest extends CrudRepository<User, Integer> {

    @RestResource(path = "by-username")
    User findByUsername(@Param("username") String username);

    @RestResource(path = "by-lastName")
    List<User> findByLastName(@Param("lastName") String lastName);


}