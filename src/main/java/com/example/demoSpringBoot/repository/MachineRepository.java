package com.example.demoSpringBoot.repository;

import com.example.demoSpringBoot.model.Customer;
import com.example.demoSpringBoot.model.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, String> {
    Machine getById(String id);

    @Query("SELECT m FROM Machine m WHERE m.id LIKE %?1%")
    List<Machine> searchMachineById(String keyword);

}
