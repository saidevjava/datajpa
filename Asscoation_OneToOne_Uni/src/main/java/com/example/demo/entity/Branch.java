package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Branch {
	@Id
	
	/*
	 * if we use MapsId generatedValue is not required
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	private int id;
	private String branchName;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "branch_id") private Accounts accounts;
	 */
	
	@OneToOne
	@MapsId
	private Accounts accounts;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "branch_id") private Set<Accounts> accounts;
	 */
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "branch_id") private Set<Accounts> accounts;
	 */
}
