package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AutomobilePlan;

public interface AutomobileRepo extends JpaRepository<AutomobilePlan, Integer> {
	
}
