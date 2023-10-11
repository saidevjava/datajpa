package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InsurancePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * in table per class we should not use the generator identity
	 */
	private int planNo;
	private String planName;
}
