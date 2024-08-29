package com.example.demoSpringBoot.service;

import com.example.demoSpringBoot.model.Services;
import com.example.demoSpringBoot.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Services saveService(Services services) {
        return this.serviceRepository.save(services);
    }

    public List<Services> getAllService() {
        return this.serviceRepository.findAll();
    }

    public Services getServiceById(String id) {
        return this.serviceRepository.getById(id);
    }

    public Boolean existsByServiceId(String id) {
        return this.serviceRepository.existsById(id);
    }

    public List<Services> searchService(String keyword) {
        return this.serviceRepository.searchServiceById(keyword);
    }
}
