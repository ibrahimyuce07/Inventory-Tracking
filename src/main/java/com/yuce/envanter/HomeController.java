package com.yuce.envanter;

import com.yuce.envanter.api.CustomerRest;
import com.yuce.envanter.api.OrderRest;
import com.yuce.envanter.api.ProductRest;
import com.yuce.envanter.api.SupplierRest;
import com.yuce.envanter.model.Customer;
import com.yuce.envanter.model.Order;
import com.yuce.envanter.model.Product;
import com.yuce.envanter.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        int y0 = 0; //10 days ago
        int y1 = 0; //9 days ago
        int y2 = 0; //8 days ago
        int y3 = 0; //7 days ago
        int y4 = 0; //6 days ago
        int y5 = 0; //5 days ago
        int y6 = 0; //4 days ago
        int y7 = 0; //3 days ago
        int y8 = 0; //2 days ago
        int y9 = 0; //yesterday
        int y10 = 0; //today
        Iterable<Order> orders = orderRest.findAll();
        for (Order order : orders) {
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(10))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y0++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(9))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y1++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(8))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y2++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(7))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y3++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(6))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y4++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(5))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y5++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(4))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y6++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(3))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y7++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(2))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y8++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now().minusDays(1))) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y9++;
                }
            }
            if (order.getOrderDate().toLocalDate().equals(LocalDate.now())) {
                for (int i = 0; i < order.getQuantity(); i++) {
                    y10++;
                }
            }
        }

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