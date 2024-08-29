package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.model.MachineUsage;
import com.example.demoSpringBoot.repository.MachineRepository;
import com.example.demoSpringBoot.repository.MachineUsageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MachineUsageService {
    private final MachineUsageRepository machineUsageRepository;

    public MachineUsageService(MachineUsageRepository machineUsageRepository) {
        this.machineUsageRepository = machineUsageRepository;
    }

    public MachineUsage saveMachineUsage(MachineUsage machineUsage) {
        return this.machineUsageRepository.save(machineUsage);
    }
}
