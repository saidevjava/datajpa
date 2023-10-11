package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

	/*
	 * //to solve the N+1 problem
	 * 
	 * @Query("SELECT branch from Branch branch LEFT JOIN FETCH branch.accounts")
	 * List<Branch> findAllBranch();
	 */
}
