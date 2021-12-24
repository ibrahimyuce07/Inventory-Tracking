package com.yuce.envanter.thymeleaf;

import com.yuce.envanter.controller.ProductRest;
import com.yuce.envanter.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRest productRest;


    @RequestMapping
    public String showProduct(Model model) {
        Iterable<Product> products = productRest.findAll();
        model.addAttribute("products", products);
        return "product_home";
    }

    @RequestMapping("/showFormForAdd")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product_add";
    }


    @RequestMapping("/save")
    public String saveProduct(Product product) {
        product.setCreatedDate(LocalDateTime.now());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getName();
        product.setCreatedBy(0);

        productRest.save(product);
        return "redirect:/product";
    }


    @RequestMapping("/delete")
    public String deleteProduct(Integer id) {
        productRest.deleteById(id);
        return "redirect:/product";
    }

    @RequestMapping("/showFormForUpdate")
    public String editProduct(Integer id, Model model) {
        model.addAttribute("productId", productRest.findById(id));
        return "product_edit";
    }
}

