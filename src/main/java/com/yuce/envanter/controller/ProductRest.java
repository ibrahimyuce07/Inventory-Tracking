package com.yuce.envanter.controller;

import com.yuce.envanter.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "productapi", path = "productapi")
public interface ProductRest extends CrudRepository<Product, Integer> {
    @RestResource(path = "byName")
    List<Product> findByName(@Param("name") String name);

    @RestResource(path = "byType")
    List<Product> findByType(@Param("type") String type);

    @RestResource(path = "byPriceRange")
    List<Product> findByPriceBetween(@Param("min") Double min, @Param("max") Double max);


}