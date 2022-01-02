package com.yuce.envanter.api;

import com.yuce.envanter.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "customerapi", path = "customerapi")
public interface CustomerRest extends CrudRepository<Customer, Integer> {
}