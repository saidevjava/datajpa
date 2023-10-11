package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Branch;

public interface BranchService {
		
	public Accounts fetchAccounts(int id);
	
	public Branch fetchBranch(int id);
	
	public List<Branch> fetchBranchAll();
	
	public Accounts createAccount(Accounts accounts);
	
	public Branch createBranch(Branch branch);
	
	public List<Branch> deleteBranch(int id);
	
	public List<Branch> deleteBranchWithOutCascade(int id);
}
