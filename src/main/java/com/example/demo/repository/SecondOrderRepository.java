package com.example.demo.repository;

import com.example.demo.model.SecondOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondOrderRepository extends JpaRepository<SecondOrder, Long> {
}
