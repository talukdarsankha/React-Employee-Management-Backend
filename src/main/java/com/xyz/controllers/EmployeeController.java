package com.xyz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.model.Employee;
import com.xyz.service.EmpService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empService.createEmp(employee), HttpStatus.CREATED);          
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmp(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmp(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int id){
		return new ResponseEntity<Employee>(empService.getEmpById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
		empService.deleteEmp(id);
		return new ResponseEntity<String>("Deleted Successfully....", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(empService.updateEmp(id, employee), HttpStatus.OK) ;
	}
	
	

}
