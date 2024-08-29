package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.model.Customer;
import com.example.demoSpringBoot.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // gọi trang tạo mới
    @GetMapping(value = "/create/customer")
    public String getCreateCustomer(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "createCustomer";
    }

    @PostMapping(value = "/view/create/customer")
    public String createCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
        if(customerService.existsByCustomerId(customer.getId())) {
            bindingResult.rejectValue("id", "error.customer", "Mã khách hàng đã tồn tại");
        }
        // Kiểm tra nếu có lỗi validate
        if (bindingResult.hasErrors()) {
            return "createCustomer";
        }
        this.customerService.saveCustomer(customer);
        return "redirect:/select/customer";  // chuyển hướng qua url /select/customer
    }

    //liệt kê ra list khách hàng
    @GetMapping(value = "/select/customer")
    public String getCustomer(Model model, @Param("keyword") String keyword) {
        List<Customer> customers = this.customerService.getAllCustomer();
        // điều kiện cho chức năng Search
        if(keyword != null) {
            customers = this.customerService.searchCustomer(keyword);
        }
        model.addAttribute("customer", customers);
        return "selectCustomer";
    }

    // gọi trang cập nhật
    @GetMapping(value = "/update/customer/{id}")
    public String getUpdateCustomer(Model model, @PathVariable String id) {
        Customer updateCustomer = this.customerService.getCustomerById(id);
        model.addAttribute("newCustomer", updateCustomer);
        return "updateCustomer";
    }

    @PostMapping(value = "/view/update/customer")
    public String updateCustomer(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateCustomer";
        }
        this.customerService.saveCustomer(customer);
        System.out.println("ccccccc");
        return "redirect:/select/customer";  // chuyển hướng qua url /select/customer
    }
}
