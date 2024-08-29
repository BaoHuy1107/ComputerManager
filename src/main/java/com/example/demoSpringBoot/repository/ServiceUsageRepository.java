package com.example.demoSpringBoot.repository;

import com.example.demoSpringBoot.model.ServiceUsage;
import com.example.demoSpringBoot.model.ServiceUsageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceUsageRepository extends JpaRepository<ServiceUsage, ServiceUsageId> {

}
