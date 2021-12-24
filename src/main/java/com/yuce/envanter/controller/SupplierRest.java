package com.yuce.envanter.controller;

import com.yuce.envanter.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "supplier", path = "supplier")
public interface SupplierRest extends CrudRepository<Supplier, Integer> {
}