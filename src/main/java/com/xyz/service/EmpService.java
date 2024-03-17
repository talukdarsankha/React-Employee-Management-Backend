package com.xyz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyz.model.Employee;


public interface EmpService {
	
	public Employee createEmp(Employee employee);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpById(int id);
	
	public void deleteEmp(int id);
	
	public Employee updateEmp(int id,Employee employee);
	

}
