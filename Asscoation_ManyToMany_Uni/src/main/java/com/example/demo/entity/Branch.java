package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String branchName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "branch_account",
		joinColumns = { @JoinColumn(name = "branch_id") },
		inverseJoinColumns = {@JoinColumn(name = "account_id")})
	private Set<Accounts> accounts;

}
