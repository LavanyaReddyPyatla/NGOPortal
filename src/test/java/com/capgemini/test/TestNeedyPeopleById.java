package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImp;

@SpringBootTest
public class TestNeedyPeopleById {
	@Mock
	private AddressDao addressDao;
	
	@Mock
	private NeedyPeopleDao needyDao;
	
	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(needyDao.findById(1)).thenReturn(Optional.of(new NeedyPeople()));
		when(needyDao.findById(2)).thenReturn(Optional.empty());
	}
	
	@Test
	public void testNeedyPeopleById() throws  NoSuchNeedyPeopleException{
		assertNotNull(employeeService.findNeedyPeopleById(1));
	}
	
	
	 @Test 
	public void testNeedyPeopleById2() throws NoSuchNeedyPeopleException {
		assertThrows(NoSuchNeedyPeopleException.class,()->employeeService.findNeedyPeopleById(2));
	  
	 }
	 
	
	
	
}