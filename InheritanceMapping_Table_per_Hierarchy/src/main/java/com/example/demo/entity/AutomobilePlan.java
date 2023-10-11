package com.example.demo.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@DiscriminatorValue("automobile")
@Data
@EqualsAndHashCode(callSuper = false)
public class AutomobilePlan extends InsurancePlan{
	
	private String autoPlan;
}
