package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String branchName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "branch", orphanRemoval = true)
	private Set<Accounts> accounts = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Set<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Accounts> accounts) {
		this.accounts = accounts;

		//System.err.println("accounts: " + accounts.toString());
		for (Accounts accounts2 : accounts) {
			accounts2.setBranch(this);
		}

	}
}
