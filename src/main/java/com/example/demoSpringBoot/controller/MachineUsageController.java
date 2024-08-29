package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.model.Customer;
import com.example.demoSpringBoot.model.MachineUsage;
import com.example.demoSpringBoot.service.CustomerService;
import com.example.demoSpringBoot.service.MachineService;
import com.example.demoSpringBoot.service.MachineUsageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MachineUsageController {

    private final MachineUsageService machineUsageService;

    private final CustomerService customerService;

    private final MachineService machineService;

    public MachineUsageController(MachineUsageService machineUsageService, CustomerService customerService, MachineService machineService) {
        this.machineUsageService = machineUsageService;
        this.customerService = customerService;
        this.machineService = machineService;
    }

    @GetMapping(value = "/signup/machine")
    public String getSignupMachine(Model model) {
        model.addAttribute("newMachineUsage", new MachineUsage());
        model.addAttribute("customer", customerService.getAllCustomer());
        model.addAttribute("machine", machineService.getAllMachine());
        return "signupMachine";
    }

    @PostMapping(value = "/view/signup/machine")
    public String SignupMachine(@Valid @ModelAttribute("newMachineUsage") MachineUsage machineUsage,
                                BindingResult bindingResult, Model model) {
        // Kiểm tra nếu có lỗi validate
        if (bindingResult.hasErrors()) {
            return "signupMachine";
        }

        // Nếu không có lỗi, tiếp tục lưu thông tin
        this.machineUsageService.saveMachineUsage(machineUsage);

        // Thêm thông báo đăng ký thành công
        model.addAttribute("message", "Đăng ký thành công");
        return "signupMachine";
    }
}
