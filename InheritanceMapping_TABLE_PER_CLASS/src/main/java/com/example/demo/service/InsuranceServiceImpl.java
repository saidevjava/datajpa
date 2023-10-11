package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InsurancePlan;
import com.example.demo.repo.InsuranceRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
	
	
	private InsuranceRepo insuranceRepo;

	@Override
	public InsurancePlan fetchaccidentalPlan(int id) {
		return insuranceRepo.findById(id).get();
	}

	@Override
	public InsurancePlan createlPlan(InsurancePlan accidentalPlan) {
		// TODO Auto-generated method stub
		return insuranceRepo.save(accidentalPlan);
	}

	

}
