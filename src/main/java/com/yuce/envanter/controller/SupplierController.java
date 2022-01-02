package com.yuce.envanter.controller;

import com.yuce.envanter.api.AddressRest;
import com.yuce.envanter.api.SupplierRest;
import com.yuce.envanter.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierRest supplierRest;

    @Autowired
    private AddressRest addressRest;

    @RequestMapping
    public String list(Model model) {
        Iterable<Supplier> suppliers = supplierRest.findAll();
        model.addAttribute("suppliers", suppliers);
        return "supplier_list";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Integer id, Model model) {
        Supplier supplier = new Supplier();
        if (id == null) {
            id = 0;
        }
        Optional<Supplier> supplierRestById = supplierRest.findById(id);

        if (supplierRestById != null && supplierRestById.isPresent()) {
            model.addAttribute("supplier", supplierRestById.get());
        } else {
            supplier.setId(0);
            model.addAttribute("supplier", supplier);
        }


        return "supplier_form";
    }

    @RequestMapping("/add")
    public String add(Supplier supplier) {

        if (supplier.getId() == 0) {
            supplier.setContractStart(LocalDate.now());
        } else {
            supplier.setContractStart(supplierRest.findById(supplier.getId()).get().getContractStart());
        }
        supplierRest.save(supplier);

        return "redirect:/supplier";
    }

    @RequestMapping("/delete")
    public String delete(Supplier supplier) {
        supplierRest.deleteById(supplier.getId());
        return "redirect:/supplier";
    }


}
