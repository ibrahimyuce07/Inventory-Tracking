package com.yuce.envanter;

import com.yuce.envanter.controller.CustomerRest;
import com.yuce.envanter.controller.OrderRest;
import com.yuce.envanter.controller.ProductRest;
import com.yuce.envanter.controller.SupplierRest;
import com.yuce.envanter.model.Customer;
import com.yuce.envanter.model.Order;
import com.yuce.envanter.model.Product;
import com.yuce.envanter.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    private ProductRest productRest;
    @Autowired
    private CustomerRest customerRest;
    @Autowired
    private SupplierRest supplierRest;
    @Autowired
    private OrderRest orderRest;

    @RequestMapping("/")
    public String home(Model model) {

        productCounterForTable(model);
        customerCounterForTable(model);
        supplierCounterForTable(model);
        orderCounterForTable(model);

        calculatinForGraph(model);


        return "index";

    }

    private void calculatinForGraph(Model model) {
        Iterable<Product> products = productRest.findAll();

        String x0 = LocalDate.now().minusDays(10).toString();
        String x1 = LocalDate.now().minusDays(9).toString();
        String x2 = LocalDate.now().minusDays(8).toString();
        String x3 = LocalDate.now().minusDays(7).toString();
        String x4 = LocalDate.now().minusDays(6).toString();
        String x5 = LocalDate.now().minusDays(5).toString();
        String x6 = LocalDate.now().minusDays(4).toString();
        String x7 = LocalDate.now().minusDays(3).toString();
        String x8 = LocalDate.now().minusDays(2).toString();
        String x9 = LocalDate.now().minusDays(1).toString();
        String x10 = LocalDate.now().toString();


        boolean dummy = true;

        //dummy data for graph
        BigDecimal y0 = BigDecimal.valueOf(2);
        BigDecimal y1 = BigDecimal.valueOf(4);
        BigDecimal y2 = BigDecimal.valueOf(6);
        BigDecimal y3 = BigDecimal.valueOf(8);
        BigDecimal y4 = BigDecimal.valueOf(9);
        BigDecimal y5 = BigDecimal.valueOf(7);
        BigDecimal y6 = BigDecimal.valueOf(5);
        BigDecimal y7 = BigDecimal.valueOf(3);
        BigDecimal y8 = BigDecimal.valueOf(1);
        BigDecimal y9 = BigDecimal.valueOf(3);
        BigDecimal y10 = BigDecimal.valueOf(5);


        model.addAttribute("y0", y0);
        model.addAttribute("y1", y1);
        model.addAttribute("y2", y2);
        model.addAttribute("y3", y3);
        model.addAttribute("y4", y4);
        model.addAttribute("y5", y5);
        model.addAttribute("y6", y6);
        model.addAttribute("y7", y7);
        model.addAttribute("y8", y8);
        model.addAttribute("y9", y9);
        model.addAttribute("y10", y10);

        model.addAttribute("x0", x0);
        model.addAttribute("x1", x1);
        model.addAttribute("x2", x2);
        model.addAttribute("x3", x3);
        model.addAttribute("x4", x4);
        model.addAttribute("x5", x5);
        model.addAttribute("x6", x6);
        model.addAttribute("x7", x7);
        model.addAttribute("x8", x8);
        model.addAttribute("x9", x9);
        model.addAttribute("x10", x10);


    }


    private void orderCounterForTable(Model model) {
        Iterable<Order> orders = orderRest.findAll();
        int todayOrderCount = 0;
        int last7DaysOrderCount = 0;
        int last30DaysOrderCount = 0;
        int totalOrderCount = 0;
        for (Order order : orders) {
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now())) {
                todayOrderCount++;
            }
            if (order.getOrderDate().toLocalDate().isAfter(LocalDate.now().minusDays(7))) {
                last7DaysOrderCount++;
            }
            if (order.getOrderDate().toLocalDate().isAfter(LocalDate.now().minusDays(30))) {
                last30DaysOrderCount++;
            }
            totalOrderCount++;
        }
        model.addAttribute("todayOrderCount", todayOrderCount);
        model.addAttribute("last7DaysOrderCount", last7DaysOrderCount);
        model.addAttribute("last30DaysOrderCount", last30DaysOrderCount);
        model.addAttribute("totalOrderCount", totalOrderCount);

    }

    private void supplierCounterForTable(Model model) {
        Iterable<Supplier> suppliers = supplierRest.findAll();
        int todaySupplierCount = 0;
        int last7DaysSupplierCount = 0;
        int last30DaysSupplierCount = 0;
        int totalSupplierCount = 0;
        for (Supplier supplier : suppliers) {
            if (supplier.getContractStart().equals(java.time.LocalDate.now())) {
                todaySupplierCount++;
            }
            if (supplier.getContractStart().isAfter(java.time.LocalDate.now().minusDays(7))) {
                last7DaysSupplierCount++;
            }
            if (supplier.getContractStart().isAfter(java.time.LocalDate.now().minusDays(30))) {
                last30DaysSupplierCount++;
            }
            totalSupplierCount++;
        }

        model.addAttribute("todaySupplierCount", todaySupplierCount);
        model.addAttribute("last7DaysSupplierCount", last7DaysSupplierCount);
        model.addAttribute("last30DaysSupplierCount", last30DaysSupplierCount);
        model.addAttribute("totalSupplierCount", totalSupplierCount);

    }

    private void customerCounterForTable(Model model) {
        Iterable<Customer> customers = customerRest.findAll();
        int todayCustomerCount = 0;
        int last7DaysCustomerCount = 0;
        int last30DaysCustomerCount = 0;
        int totalCustomerCount = 0;
        for (Customer customer : customers) {
            if (customer.getRegistrationDate().equals(java.time.LocalDate.now())) {
                todayCustomerCount++;
            }
            if (customer.getRegistrationDate().isAfter(java.time.LocalDate.now().minusDays(7))) {
                last7DaysCustomerCount++;
            }
            if (customer.getRegistrationDate().isAfter(java.time.LocalDate.now().minusDays(30))) {
                last30DaysCustomerCount++;
            }
            totalCustomerCount++;
        }

        model.addAttribute("todayCustomerCount", todayCustomerCount);
        model.addAttribute("last7DaysCustomerCount", last7DaysCustomerCount);
        model.addAttribute("last30DaysCustomerCount", last30DaysCustomerCount);
        model.addAttribute("totalCustomerCount", totalCustomerCount);
    }

    private void productCounterForTable(Model model) {
        Iterable<Product> products = productRest.findAll();
        int todayProductCount = 0;
        int last7DaysProductCount = 0;
        int last30DaysProductCount = 0;
        int totalProductCount = 0;
        for (Product product : products) {
            if (product.getCreatedDate().toLocalDate().equals(java.time.LocalDate.now())) {
                todayProductCount++;
            }
            if (product.getCreatedDate().toLocalDate().isAfter(java.time.LocalDate.now().minusDays(7))) {
                last7DaysProductCount++;
            }
            if (product.getCreatedDate().toLocalDate().isAfter(java.time.LocalDate.now().minusDays(30))) {
                last30DaysProductCount++;
            }
            totalProductCount++;
        }

        model.addAttribute("todayProductCount", todayProductCount);
        model.addAttribute("last7DaysProductCount", last7DaysProductCount);
        model.addAttribute("last30DaysProductCount", last30DaysProductCount);
        model.addAttribute("totalProductCount", totalProductCount);
    }
}