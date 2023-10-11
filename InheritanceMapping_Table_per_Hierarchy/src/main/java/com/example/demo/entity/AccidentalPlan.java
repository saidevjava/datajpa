package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@DiscriminatorValue("accident")
@Data
@EqualsAndHashCode(callSuper = false)
public class AccidentalPlan extends InsurancePlan{
	
	private String accidentPlanType;
}
