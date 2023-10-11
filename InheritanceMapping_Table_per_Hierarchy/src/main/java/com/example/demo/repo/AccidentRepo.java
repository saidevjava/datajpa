package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AccidentalPlan;

public interface AccidentRepo extends JpaRepository<AccidentalPlan, Integer>{

}
