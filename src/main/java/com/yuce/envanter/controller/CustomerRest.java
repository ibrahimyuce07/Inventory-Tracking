package com.yuce.envanter.controller;

import com.yuce.envanter.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRest extends CrudRepository<Customer, Integer> {
}