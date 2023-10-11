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
/*
 * @PrimaryKeyJoinColumn annotation is used in JPA (Java Persistence API) to
 * specify how to map a primary key column from the primary table to a foreign
 * key column in a secondary table when defining a relationship between
 * entities.
 */
public class AutomobilePlan extends InsurancePlan{
	
	private String autoPlan;
}
