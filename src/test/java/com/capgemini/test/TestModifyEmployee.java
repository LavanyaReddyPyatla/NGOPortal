package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.EmployeeDto;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;

import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import com.capgemini.service.AdminServiceImp;


@SpringBootTest
class TestModifyEmployee {

	@Mock
	private EmployeeDao employeeDao;
	
	@Mock
	private AddressDao addressDao;
	
	
	@InjectMocks
	private AdminService adminService = new AdminServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(employeeDao.findByEmail("ramesh3@gmail.com")).thenReturn(Optional.of(new Employee()));
		when(employeeDao.findByEmail("harsha@gmail.com")).thenReturn(Optional.empty());
		when(addressDao.save(any(Address.class))).thenReturn(new Address());
		when(employeeDao.save(any(Employee.class))).thenReturn(new Employee());
		
		when(addressDao.findById(1)).thenReturn(Optional.of(new Address()));
		when(addressDao.findById(2)).thenReturn(Optional.empty());
		
	}
	
	@Test
	public void testEditAddress1() throws NoSuchEmployeeException{
		EmployeeDto dto = new EmployeeDto(2,"ramesh","ramesh3@gmail.com","1234567890","ramesh","Pranu$","hyd","Telangana","500006","out post");

		
		assertNotNull(adminService.modifyEmployee(dto));
		
	}
	
	@Test
	public void testEditAddress2() throws NoSuchEmployeeException{
		EmployeeDto dto = new EmployeeDto(2,"ramesh","ramesh@gmail.com","1234567890","ramesh","Pranu$","hyd","Telangana","500006","out post");

		
		assertThrows(NoSuchEmployeeException.class, ()->adminService.modifyEmployee(dto));
		
	}
	
	
}
