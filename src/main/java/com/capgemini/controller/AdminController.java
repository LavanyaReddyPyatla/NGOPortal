package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.EmployeeDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.dto.SuccessMessageDto;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import com.capgemini.util.NgoPortalConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/find_employee_by_id/{id}")
	public Employee findEmployeeById(@PathVariable Integer id) throws NoSuchEmployeeException {
		return adminService.findEmployeeById(id);
	}

	@GetMapping("/find_employee_by_name/{name}")
	public List<Employee> findEmployeebyName(@PathVariable String name) throws NoSuchEmployeeException {
		return adminService.findEmployeeByName(name);
	}

	@GetMapping("/find_all_employees")
	public List<Employee> findAllEmplpyees() throws NoSuchEmployeeException {
		return adminService.findAllEmployee();
	}

	@PostMapping("/add_employee")
	public SuccessMessageDto addEmployee(@RequestBody EmployeeDto employeeDto)
			throws DuplicateEmployeeException, InValidDetailsException {
		Employee employee = adminService.addEmployee(employeeDto);
		return new SuccessMessageDto(NgoPortalConstants.EMPLOYEE_ADDED + employee.getEmployeeId());
	}

	@DeleteMapping("/remove_employee_by_id/{id}")
	public SuccessMessageDto removeEmployeeById(@PathVariable int id) throws NoSuchEmployeeException {
		adminService.removeEmployee(id);
		return new SuccessMessageDto(NgoPortalConstants.EMPLOYEE_REMOVED);
	}

	@PutMapping("/modify_employee")
	public SuccessMessageDto modifyEmployee(@RequestBody EmployeeDto employee) throws NoSuchEmployeeException {
		adminService.modifyEmployee(employee);
		return new SuccessMessageDto(NgoPortalConstants.EMPLOYEE_UPDATED + employee.getEmployeeId());
	}
	
	@PutMapping("/update_employee_status/{id}")
	public SuccessMessageDto updateRaisedAmount(@PathVariable("id") Integer id, @RequestBody EmployeeDto employeeDto)
			throws NoSuchRequestException, NoSuchEmployeeException{
		adminService.updateStatus(id, employeeDto);
		return new SuccessMessageDto(NgoPortalConstants.STATUS_UPDATED);
	}


}