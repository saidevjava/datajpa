package com.example.demo.service;

import com.example.demo.entity.InsurancePlan;

public interface InsuranceService {
		
	public InsurancePlan fetchaccidentalPlan(int id);
	/*
	 * public InsurancePlan insurancePlan(int id); public AutomobilePlan
	 * automobilePlan(int id);
	 */
	
	public InsurancePlan createlPlan(InsurancePlan accidentalPlan);
}
