package com.capgemini.test;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.AdminDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.EmployeeDto;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;
import com.capgemini.model.Employee;
import com.capgemini.service.AdminService;
import com.capgemini.service.AdminServiceImp;

@SpringBootTest
public class TestAddEmployee {
	@Mock
	private EmployeeDao employeeDao;
	@Mock
	private AdminDao adminDao;
	@Mock
	private AddressDao addressDao;
	
	@InjectMocks 
	AdminService adminService=new AdminServiceImp();
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
	public void testReadEmployee1() throws NoSuchEmployeeException, DuplicateEmployeeException, InValidDetailsException {
		EmployeeDto dto = new EmployeeDto("Siri","harsha@gmail.com","9874563215","ramesh143e","sirI@237","Hyderabad","telangana","500084","Near church");
		
		assertNotNull(adminService.addEmployee(dto));
		
	}
	

	@Test
	public void testReadEmployee2() throws NoSuchEmployeeException {
		EmployeeDto dto = new EmployeeDto("Siri","ramesh3@gmail.com","9874563215","ramesh143e","sirI@237","Hyderabad","telangana","500084","Near church");
		
		
		assertThrows(DuplicateEmployeeException.class,()-> adminService.addEmployee(dto));
		
	}
	
	@Test
	public void testViewEmployee3() throws  InValidDetailsException{
		EmployeeDto dto = new EmployeeDto("Siri","suresh@gmail.com","987456","ramesh143e","sirI@237","Hyderabad","telangana","500084","Near church");
		
		
		assertThrows(InValidDetailsException.class,()-> adminService.addEmployee(dto));
		
	}

}