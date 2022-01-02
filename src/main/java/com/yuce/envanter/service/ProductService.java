package com.yuce.envanter.service;

import com.yuce.envanter.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Deprecated
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }


    @Override
    public boolean saveOrUpdateProduct(Product product) {
        return productRepository.save(product) != null;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByType(String type) {
        String query = String.format("SELECT * FROM product WHERE product_type = '%s' ", type);
        Query q = entityManager.createNativeQuery(query);
        List<Product> result = q.getResultList();
        return result;
    }


}
