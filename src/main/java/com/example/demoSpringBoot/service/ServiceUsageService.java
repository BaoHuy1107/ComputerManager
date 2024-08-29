package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.model.ServiceUsage;
import com.example.demoSpringBoot.repository.ServiceUsageRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsageService {
    private final ServiceUsageRepository serviceUsageRepository;

    public ServiceUsageService(ServiceUsageRepository serviceUsageRepository) {
        this.serviceUsageRepository = serviceUsageRepository;
    }

    public ServiceUsage saveServiceUsage(ServiceUsage serviceUsage) {
        return this.serviceUsageRepository.save(serviceUsage);
    }
}
