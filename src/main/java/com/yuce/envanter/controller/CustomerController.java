package com.yuce.envanter.controller;

import com.yuce.envanter.api.CustomerRest;
import com.yuce.envanter.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRest customerRest;

    @RequestMapping("/")
    public String customer(Model model) {
        Iterable<Customer> customers = customerRest.findAll();
        model.addAttribute("customer", customers);
        return "customer";
    }

    @RequestMapping("/save")
    public String save(Customer customer) {
        customer.setRegistrationDate(LocalDate.now());
        customerRest.save(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/delete")
    public String delete(Customer customer) {
        customerRest.deleteById(customer.getId());
        return "redirect:/customer/list";
    }

}
