package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccidentalPlan;
import com.example.demo.entity.AutomobilePlan;
import com.example.demo.entity.InsurancePlan;
import com.example.demo.service.InsuranceService;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;
	
	@PostMapping("/createdInsurance")
	public ResponseEntity<InsurancePlan> fetchDetails(@RequestBody InsurancePlan insurancePlan){
		InsurancePlan createlPlan = insuranceService.createlPlan(insurancePlan);
		return ResponseEntity.status(HttpStatus.CREATED).body(createlPlan);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<InsurancePlan> fetch(@PathVariable int id){
		return ResponseEntity.ok(insuranceService.fetchaccidentalPlan(id));
	}
	
	
	@PostMapping("/createdAccident")
	public ResponseEntity<AccidentalPlan> fetchDetailsAccident(@RequestBody AccidentalPlan insurancePlan){
		InsurancePlan createlPlan = insuranceService.createlPlan(insurancePlan);
		return ResponseEntity.status(HttpStatus.CREATED).body((AccidentalPlan)createlPlan);
	}
	
	@PostMapping("/createdAutomobile")
	public ResponseEntity<AutomobilePlan> fetchDetailsInsurance(AutomobilePlan insurancePlan){
		InsurancePlan createlPlan = insuranceService.createlPlan(insurancePlan);
		return ResponseEntity.status(HttpStatus.CREATED).body((AutomobilePlan)createlPlan);
	}
}
