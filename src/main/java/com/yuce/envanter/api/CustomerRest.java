package com.yuce.envanter.api;

import com.yuce.envanter.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;


@RepositoryRestResource(collectionResourceRel = "customerapi", path = "customerapi")
public interface CustomerRest extends CrudRepository<Customer, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE customer_table SET blocked = ?1 WHERE id = ?2", nativeQuery = true)
    public void blockCustomer(boolean blocked, int id);
}