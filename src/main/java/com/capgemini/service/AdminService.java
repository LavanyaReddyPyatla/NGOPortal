package com.capgemini.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.dto.EmployeeDto;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Employee;

@Repository
public interface AdminService {

	public Employee modifyEmployee(EmployeeDto employee) throws NoSuchEmployeeException;

	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException;

	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException;

	public List<Employee> findAllEmployee() throws NoSuchEmployeeException;

	public Employee addEmployee(EmployeeDto employeeDto) throws DuplicateEmployeeException, InValidDetailsException;

	public Employee findEmployeeById(Integer employeeId) throws NoSuchEmployeeException;

	void updateStatus(Integer id, EmployeeDto employeeDto) throws NoSuchEmployeeException;
}
