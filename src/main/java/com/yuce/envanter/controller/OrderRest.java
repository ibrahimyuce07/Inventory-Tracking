package com.yuce.envanter.controller;

import com.yuce.envanter.model.Customer;
import com.yuce.envanter.model.Order;
import com.yuce.envanter.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "orderapi", path = "orderapi")
public interface OrderRest extends CrudRepository<Order, Integer> {
    @RestResource(path = "orderNumber")
    List<Order> findByOrderNumber(@Param("orderNumber") String orderNumber);

    @RestResource(path = "orderAccepted")
    List<Order> findByOrderAccepted(@Param("orderAccepted") boolean orderAccepted);

    @RestResource(path = "orderShipped")
    List<Order> findByOrderShipped(@Param("orderShipped") boolean orderShipped);


}
