package com.example.spring_python.repository;

import com.example.spring_python.entity.HybridOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HybridOrderRepository extends JpaRepository<HybridOrder, Long> {

}
