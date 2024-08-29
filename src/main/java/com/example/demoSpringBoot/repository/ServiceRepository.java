package com.example.demoSpringBoot.repository;

import com.example.demoSpringBoot.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services, String> {
    Services getById(String id);

    @Query("SELECT s FROM Services s WHERE s.id LIKE %?1%")
    List<Services> searchServiceById(String keyword);
}
