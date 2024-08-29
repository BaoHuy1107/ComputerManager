package com.example.demoSpringBoot.repository;

import com.example.demoSpringBoot.model.MachineUsage;
import com.example.demoSpringBoot.model.MachineUsageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface MachineUsageRepository extends JpaRepository<MachineUsage, MachineUsageId> {

}

