package com.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.model.Employee;
import com.xyz.repository.EmpRepository;


@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee createEmp(Employee employee) {
		// TODO Auto-generated method stub
		return empRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return empRepository.findById(id).get();
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		Employee employee= empRepository.findById(id).get();
		if(employee!=null) {
			empRepository.delete(employee);
		}
	}

	@Override
	public Employee updateEmp(int id, Employee employee) {
		// TODO Auto-generated method stub
		Employee previousEmployee= empRepository.findById(id).get();
		if(previousEmployee!=null) {
			employee.setId(id);
			return empRepository.save(employee);
		}
		
		return null;
	}

}
