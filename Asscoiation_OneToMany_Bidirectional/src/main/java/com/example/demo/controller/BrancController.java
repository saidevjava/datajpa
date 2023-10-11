package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.Branch;
import com.example.demo.service.BranchService;

@RestController
public class BrancController {

	@Autowired
	private BranchService branchService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Branch>> findAll(){
		return ResponseEntity.ok(branchService.fetchBranchAll());
	}
	

	@PostMapping("/createBranch")
	public ResponseEntity<Branch> createBranch(@RequestBody Branch branch){
		return ResponseEntity.status(HttpStatus.CREATED).body(branchService.createBranch(branch));
	}
	
	@PostMapping("/createAccounts")
	public ResponseEntity<Accounts> createAccounts(@RequestBody Accounts accounts){
		return ResponseEntity.status(HttpStatus.CREATED).body(branchService.createAccount(accounts));
	}
	
	@GetMapping("/fetchBranch/{id}")
	public ResponseEntity<Branch> fetchBranch(@PathVariable int id){
		return ResponseEntity.ok(branchService.fetchBranch(id));
	}
	
	@GetMapping("/fetchAccount/{id}")
	public ResponseEntity<Accounts> fetchAccount(@PathVariable int id){
		return ResponseEntity.ok(branchService.fetchAccounts(id));
	}
	@DeleteMapping("/deleteBranch/{id}")
	public ResponseEntity<List<Branch>> deleteBranch(@PathVariable int id){
		return ResponseEntity.ok(branchService.deleteBranch(id));
	}
}
