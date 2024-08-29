package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.model.ServiceUsage;
import com.example.demoSpringBoot.service.CustomerService;
import com.example.demoSpringBoot.service.ServiceService;
import com.example.demoSpringBoot.service.ServiceUsageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServiceUsageController {
    private final ServiceUsageService serviceUsageService;

    private final CustomerService customerService;

    private final ServiceService serviceService;

    public ServiceUsageController(ServiceUsageService serviceUsageService, CustomerService customerService,
                                  ServiceService serviceService) {
        this.serviceUsageService = serviceUsageService;
        this.customerService = customerService;
        this.serviceService = serviceService;
    }

    @GetMapping(value = "/signup/service")
    public String getSignupService(Model model) {
        model.addAttribute("newServiceUsage", new ServiceUsage());
        model.addAttribute("customer", this.customerService.getAllCustomer());
        model.addAttribute("service", this.serviceService.getAllService());
        return "signupService";
    }

    @PostMapping(value = "view/signup/service")
    public String signupService(@Valid @ModelAttribute("newServiceUsage") ServiceUsage serviceUsage,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "signupService";
        }
        // Nếu không có lỗi, tiếp tục lưu thông tin
        this.serviceUsageService.saveServiceUsage(serviceUsage);

        // Thêm thông báo đăng ký thành công
        model.addAttribute("message", "Đăng ký thành công");
        return "signupService";
    }
}
