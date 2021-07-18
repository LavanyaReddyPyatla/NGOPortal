package com.capgemini.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByEmployeeName(String name);

	Optional<Employee> findByEmail(String email);
}
