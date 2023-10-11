package com.example.demo.service;

import java.util.List;
import java.util.Set;

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
		/*
		 * //below line of code will cause the N+1 Problem return branchRepo.findAll();
		 */

		return branchRepo.findAllBranch();
	}

	@Override
	public Accounts createAccount(Accounts accounts) {
		return accountsRepo.save(accounts);
	}

	@Override
	public Branch createBranch(Branch branch) {
		/*
		 * // if cascade is not applied we have to add the below steps Set<Accounts>
		 * accounts = branch.getAccounts(); for (Accounts accounts2 : accounts) {
		 * accountsRepo.save(accounts2); }
		 * 
		 * 
		 * Set<Accounts> accounts = branch.getAccounts(); for (Accounts accounts2 :
		 * accounts) { if(accounts2.getBranch()!=null) { accounts2.setBranch(branch); }
		 * }
		 * 
		 * //Branch save = branchRepo.save(branch);
		 */ Branch save = branchRepo.save(branch);
		return save;
	}
	
	@Override
	public List<Branch> deleteBranchWithOutCascade(int id) {

		/*
		 * Branch branch = branchRepo.findById(id).get(); Set<Accounts> accounts =
		 * branch.getAccounts(); for (Accounts accounts2 : accounts) {
		 * branch.getAccounts().remove(accounts2); } branchRepo.delete(branch); return
		 * branchRepo.findAll();
		 */
		return null;
	}

	@Override
	public List<Branch> deleteBranch(int id) {
		Branch branch = branchRepo.findById(id).get();
		branchRepo.delete(branch);
		return branchRepo.findAll();
	}

}
