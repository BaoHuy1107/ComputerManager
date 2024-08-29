package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.model.Services;
import com.example.demoSpringBoot.service.ServiceService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ServiceController {
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "/create/service")
    public String getCreateService(Model model) {
        model.addAttribute("newService", new Services());
        return "createService";
    }

    @RequestMapping(value = "/view/create/service", method = RequestMethod.POST)
    public String createService(@Valid @ModelAttribute("newService") Services services, BindingResult bindingResult) {
        if (serviceService.existsByServiceId(services.getId())) {
            bindingResult.rejectValue("id", "error.service", "Mã dịch vụ này đã tồn tại");
        }
        // Kiểm tra nếu có lỗi validate
        if (bindingResult.hasErrors()) {
            return "createService";
        }
        this.serviceService.saveService(services);
        return "redirect:/select/service";  // chuyển hướng qua url /select/service
    }

    @GetMapping(value = "/select/service")
    public String getService(Model model, @Param("keyword") String keyword) {
        List<Services> services = this.serviceService.getAllService();
        if (keyword != null) {
            services = this.serviceService.searchService(keyword);
        }
        model.addAttribute("service", services);
        return "selectService";
    }

    // gọi trang cập nhật
    @GetMapping(value = "/update/service/{id}")
    public String getUpdateService(Model model, @PathVariable String id) {
        Services updateService = this.serviceService.getServiceById(id);
        model.addAttribute("newService", updateService);
        return "updateService";
    }

    @PostMapping(value = "/view/update/service")
    public String updateService(@Valid @ModelAttribute("newService") Services service, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateService";
        }
        this.serviceService.saveService(service);
        return "redirect:/select/service";  // chuyển hướng qua url /select/service
    }
}
