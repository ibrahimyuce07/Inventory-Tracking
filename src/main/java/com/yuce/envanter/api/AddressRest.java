package com.yuce.envanter.api;

import com.yuce.envanter.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressapi", path = "addressapi")
public interface AddressRest extends CrudRepository<Address, Integer> {


}
