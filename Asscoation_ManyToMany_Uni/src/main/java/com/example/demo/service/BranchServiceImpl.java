package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Branch;
import com.example.demo.repo.AccountsRepo;
import com.example.demo.repo.BranchRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {

	private AccountsRepo accountsRepo;
	private BranchRepo branchRepo;

	@Override
	public Accounts fetchAccounts(int id) {

		return accountsRepo.findById(id).get();
	}

	@Override
	public Branch fetchBranch(int id) {
		return branchRepo.findById(id).get();
	}

	@Override
	public List<Branch> fetchBranchAll() {

		// below line of code will cause the N+1 Problem
		return branchRepo.findAll();

		/* return branchRepo.findAllBranch(); */
	}

	@Override
	public Accounts createAccount(Accounts accounts) {
		/* when we try to save the child without saving the parent
		 * org.hibernate.TransientPropertyValueException: object references an unsaved
		 * transient instance - save the transient instance before flushing :
		 * com.example.demo.entity.Accounts.branch -> com.example.demo.entity.Branch
		 */
		
		/*
		 * // to avoid below line of code use cascade Branch branch =
		 * accounts.getBranch(); branchRepo.save(branch);
		 */
		return accountsRepo.save(accounts);
	}

	@Override
	public Branch createBranch(Branch branch) {
		/*
		 * // if cascade is not applied we have to add the below steps Set<Accounts>
		 * accounts = branch.getAccounts(); for (Accounts accounts2 : accounts) {
		 * accountsRepo.save(accounts2); }
		 */
		Branch save = branchRepo.save(branch);
		return save;
	}

	@Override
	public List<Branch> deleteBranch(int id) {
		Branch branch = branchRepo.findById(id).get();
		branchRepo.delete(branch);
		// TODO Auto-generated method stub
		return branchRepo.findAll();
	}

	@Override
	public List<Accounts> deleteAccount(int id) {
		Accounts accounts = accountsRepo.findById(id).get();
		accountsRepo.delete(accounts);
		return accountsRepo.findAll();
	}

}
