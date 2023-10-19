package com.example.transactions.controller;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.entity.Employee;

@RestController
public class EmployeeController {

	private final List<Employee> employeeList;
	private Map<String, Long> collect;

	@Autowired
	public EmployeeController(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@GetMapping("/all")
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	@GetMapping("/maleAndFemaleEmployeesCount")
	public Map<String, Long> maleAndFemaleEmployeesCount() {
		Map<String, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		return collect;
	}

	@GetMapping("/allDepartmentNames")
	public List<String> allDepartmentNames() {
		List<String> collect = employeeList.stream().map(employeeList -> employeeList.getDepartment()).distinct()
				.collect(Collectors.toList());
		/*
		 * //Set<String> collect = employeeList.stream().
		 * map(employeeList->employeeList.getDepartment()).collect(Collectors.toSet());
		 */
		return collect;
	}

	@GetMapping("/averageAgeMaleAndFemaleEmployees")
	public Map<String, Double> averageAgeMaleAndFemaleEmployees() {
		// Double collect =
		// employeeList.stream().collect(Collectors.averagingInt(Employee::getAge));
		Map<String, Double> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		return collect;
	}

	@GetMapping("/highestPaidEmployee")
	public Optional<Employee> highestPaidEmployee() {
		Optional<Employee> collect = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		return collect;
	}

	@GetMapping("/listEmployeesAfterJoined")
	public List<String> listEmployeesAfterJoined() {
		// List<Employee> collect =
		// employeeList.stream().filter(emp->emp.getYearOfJoining()>2015).collect(Collectors.toList());
		List<String> collect = employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015).map(Employee::getName)
				.collect(Collectors.toList());
		return collect;
	}

	@GetMapping("/countEmployeesByDepartment")
	public Map<String, Long> countEmployeesByDepartment() {
		Map<String, Long> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		return collect;
	}

	@GetMapping("/avgSalaryOfEachDepartment")
	public Map<String, Double> avgSalaryOfEachDepartment() {
		Map<String, Double> collect = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		return collect;
	}

	@GetMapping("/youngestEmployee")
	public Employee youngestEmployee() {
		Optional<Employee> collect = employeeList.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
		return collect.get();
	}

	@GetMapping("/youngestMaleEmployeeInproductDepartmet")
	public Employee youngestMaleEmployeeInproductDepartmet() {
		Optional<Employee> collect = employeeList.stream()
				.filter(emp -> emp.getGender() == "Male" && emp.getDepartment() == "Product Development")
				.collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
		return collect.get();
	}

	@GetMapping("/mostWorkingExperiance")
	public Employee mostWorkingExperiance() {
		Optional<Employee> findFirst = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst();
		return findFirst.get();
	}

	@GetMapping("/maleAndFemaleSalesMarketing")
	public Map<String, Long> maleAndFemaleSalesMarketing() {
		Map<String, Long> collect2 = employeeList.stream()
				.filter(emp -> emp.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		return collect2;
	}
	
	@GetMapping("/avgSalaryofMaleAndFemale")
	public Map<String, Double> avgSalaryofMaleAndFemale() {
		Map<String, Double> collect2 = employeeList.stream().
				collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		return collect2;
	}
	
	@GetMapping("/listAllNamesofEmployees")
	public Map<String, List<String>> listAllNamesofEmployees() {
		Map<String, List<Employee>> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet = collect2.entrySet();
		Map<String, List<String>> mapList = new HashMap<>();
		for (Entry<String, List<Employee>> entry : entrySet) {
			List<Employee> value = entry.getValue();
			System.out.println(value);
			mapList.put(entry.getKey(), value.stream().map(Employee::getName).collect(Collectors.toList()));
		}
		return mapList;
	}
	
	@GetMapping("/avgSalaryAndTotalSalaryOrganization")
	public Map<String, Double> avgSalaryAndTotalSalaryOrganization(){
		DoubleSummaryStatistics collect2 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		Map<String, Double> hashMap = new HashMap<>();
		hashMap.put("AverageSalary", collect2.getAverage());
		hashMap.put("TotalSalary", collect2.getSum());
		return hashMap;
	}
	
	@GetMapping("/separateEmployeesAgeLessthan25AndAbove25")
	public Map<String, List<String>> separateEmployeesAgeLessthan25AndAbove25(){
		Map<Boolean, List<Employee>> collect2 = employeeList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()>25));
		Set<Entry<Boolean, List<Employee>>> entrySet = collect2.entrySet();
		HashMap<String, List<String>> hashMap = new HashMap<>();
		for (Entry<Boolean, List<Employee>> entry : entrySet) {
			if(entry.getKey()) {
				hashMap.put("employee above 25", entry.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
			}else {
				hashMap.put("employee below 25", entry.getValue().stream().map(Employee::getName).collect(Collectors.toList()));
			}
		}
		return hashMap;
	}
	
	@GetMapping("/oldesEnployeeInTheOrganize")
	public Employee oldesEnployeeInTheOrganize() {
		Optional<Employee> max = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		return max.get();
	}
}
