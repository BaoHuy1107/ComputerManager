package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.model.Machine;
import com.example.demoSpringBoot.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public Machine saveMachine(Machine machine) {
        return this.machineRepository.save(machine);
    }

    public List<Machine> getAllMachine() {
        return this.machineRepository.findAll();
    }

    public Machine getMachineById(String id) {
        return this.machineRepository.getById(id);
    }

    public boolean existsByMachineId(String id) {
        return this.machineRepository.existsById(id);
    }

    public List<Machine> searchMachine(String keyword) {
        return this.machineRepository.searchMachineById(keyword);
    }
}
