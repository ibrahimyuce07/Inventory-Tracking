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
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRest productRest;


    @RequestMapping
    public String showProduct(Model model) {
        Iterable<Product> products = productRest.findAll();
        String createdDateStr = "";
        String modifiedDateStr = "";
        for (Product product : products) {
            if (product.getCreatedDate() != null)
                createdDateStr = product.getCreatedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            if (product.getModifiedDate() != null)
                modifiedDateStr = product.getModifiedDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        }
        model.addAttribute("products", products);
        model.addAttribute("createdDateStr", createdDateStr);
        model.addAttribute("modifiedDateStr", modifiedDateStr);
        return "product_list";
    }

    @RequestMapping("/showFormForAdd")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product_add";
    }

    @RequestMapping("/save")
    public String saveProduct(Product product) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        product.setCreatedBy(authentication.getName());
        product.setCreatedDate(LocalDateTime.now());

        productRest.save(product);
        return "redirect:/product";
    }

    @RequestMapping("/update")
    public String updateProduct(Product product) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        product.setCreatedDate(productRest.findById(product.getId()).get().getCreatedDate());
        product.setCreatedBy(productRest.findById(product.getId()).get().getCreatedBy());
        product.setModifiedBy(authentication.getName());
        product.setModifiedDate(LocalDateTime.now());

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

        Optional<Product> productRestById = productRest.findById(id);
        model.addAttribute("product", productRestById.get());
        return "product_edit";
    }
}

