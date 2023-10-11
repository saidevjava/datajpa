package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn
public class AccidentalPlan extends InsurancePlan{
	
	private String accidentPlanType;
}
