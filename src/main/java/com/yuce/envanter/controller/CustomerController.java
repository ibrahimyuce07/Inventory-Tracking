package com.yuce.envanter.controller;

import com.yuce.envanter.api.CustomerRest;
import com.yuce.envanter.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRest customerRest;

    @RequestMapping
    public String customer(Model model) {
        Iterable<Customer> customers = customerRest.findAll();
        model.addAttribute("customer", customers);
        return "customer_list";
    }

    @RequestMapping("/block")
    public String block(Customer customer) {
        customerRest.blockCustomer(true, customer.getId());
        return "redirect:/customer";
    }

    @RequestMapping("/delete")
    public String delete(Customer customer) {
        customerRest.deleteById(customer.getId());
        return "redirect:/customer";
    }

}
