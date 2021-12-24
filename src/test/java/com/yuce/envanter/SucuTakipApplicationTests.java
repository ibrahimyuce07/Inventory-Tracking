package com.yuce.envanter;

import com.yuce.envanter.controller.ProductRest;
import com.yuce.envanter.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SucuTakipApplicationTests {

    @Autowired
    private ProductRest productRest;

    @Test
    void testProductFindAll() {
        Iterable<Product> all = productRest.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void testProductFindById() {
        String type = "iPad";
        List<Product> byType = productRest.findByType(type);
        byType.forEach(System.out::println);
    }


}
