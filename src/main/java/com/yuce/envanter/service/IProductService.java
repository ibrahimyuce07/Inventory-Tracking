package com.yuce.envanter.service;

import com.yuce.envanter.model.Product;

import java.util.List;

@Deprecated
public interface IProductService {

    List<Product> getProducts();

    Product getProduct(Integer id);

    boolean saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> getProductsByType(String type); //native query example

}


