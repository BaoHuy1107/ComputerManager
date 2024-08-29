package com.example.demoSpringBoot.controller;

import com.example.demoSpringBoot.model.Customer;
import com.example.demoSpringBoot.model.Machine;
import com.example.demoSpringBoot.service.MachineService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MachineController {
    private final MachineService machineService;

    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping(value = "/create/machine")
    public String getCreateMachine(Model model) {
        model.addAttribute("newMachine", new Machine());
        return "createMachine";
    }

    @PostMapping(value = "/view/create/machine")
    public String createMachine(@Valid @ModelAttribute("newMachine") Machine machine, BindingResult bindingResult) {
        if(machineService.existsByMachineId(machine.getId())) {
            bindingResult.rejectValue("id", "error.machine", "Mã máy đã tồn tại");
        }
        if(bindingResult.hasErrors()) {
            return "createMachine";
        }
        this.machineService.saveMachine(machine);
        return "redirect:/select/machine";  // chuyển hướng qua url /select/machine
    }

    // gọi trang danh sách
    @GetMapping(value = "/select/machine")
    public String getMachine(Model model, @Param("keyword") String keyword) {
        List<Machine> machines = this.machineService.getAllMachine();
        if(keyword != null) {
            machines = this.machineService.searchMachine(keyword);
        }
        model.addAttribute("machine", machines);
        System.out.println(machines);
        return "selectMachine";
    }

    // gọi trang cập nhật
    @GetMapping(value = "/update/machine/{id}")
    public String getUpdateMachine(Model model, @PathVariable String id) {
        Machine updateMachine = this.machineService.getMachineById(id);
        model.addAttribute("newMachine", updateMachine);
        return "updateMachine";
    }

    @PostMapping(value = "/view/update/machine")
    public String updateMachine(@Valid @ModelAttribute("newMachine") Machine machine, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "updateMachine";
        }
        this.machineService.saveMachine(machine);
        return "redirect:/select/customer";  // chuyển hướng qua url /select/machine
    }
}
