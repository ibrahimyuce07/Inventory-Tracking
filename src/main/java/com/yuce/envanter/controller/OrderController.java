package com.yuce.envanter.controller;

import com.yuce.envanter.api.AddressRest;
import com.yuce.envanter.api.OrderRest;
import com.yuce.envanter.model.Address;
import com.yuce.envanter.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRest orderRest;

    @Autowired
    private AddressRest addressRest;

    @RequestMapping("/")
    public String orders(Model model) {
        model.addAttribute("orders", orderRest.findAll());
        model.addAttribute("addresses", addressRest.findAll());
        return "order_list";
    }

    @RequestMapping("/add")
    public String addOrder(Order order, Address address) {
        Address savedAddress = addressRest.save(address);
        order.setShipping(savedAddress);
        orderRest.save(order);

        return "redirect:/order";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Integer id, Model model) {
        Order order = new Order();
        if (id == null) {
            id = 0;
        }
        Optional<Order> orderRestById = orderRest.findById(id);
        if (orderRestById.isPresent()) {
            model.addAttribute("order", orderRestById.get());
        } else {
            order.setId(0);
            model.addAttribute("order", order);
        }
        return "order_form";
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        orderRest.deleteById(id);
        return "redirect:/order";
    }
}
