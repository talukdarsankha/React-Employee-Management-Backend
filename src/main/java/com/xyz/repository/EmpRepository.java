package com.xyz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyz.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
