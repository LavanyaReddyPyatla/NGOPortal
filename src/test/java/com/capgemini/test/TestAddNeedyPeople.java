package com.capgemini.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.dto.NeedyPeopleDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.model.Address;
import com.capgemini.model.NeedyPeople;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceImp;

@SpringBootTest
public class TestAddNeedyPeople {

	@Mock
	private NeedyPeopleDao needyDao;
	
	@Mock
	private AddressDao addressdao;
	
	@InjectMocks
	EmployeeService employeeService = new EmployeeServiceImp(); 
	
	@BeforeEach
	public void beforeEach()
	{
		when(needyDao.findByEmail("siri4@gmail.com")).thenReturn(Optional.of(new NeedyPeople()));
		when(needyDao.findByEmail("suresh@gmail.com")).thenReturn(Optional.empty());
		when(addressdao.save(any(Address.class))).thenReturn(new Address());
		when(needyDao.save(any(NeedyPeople.class))).thenReturn(new NeedyPeople());
	}
	
	@Test
	public void testViewNeedyPeople1() throws DuplicateNeedyPersonException, InValidDetailsException{
		NeedyPeopleDto dto = new NeedyPeopleDto("Siri","1234567891",5000.0,"suresh@gmail.com","sirI@237","Hyderabad","telangana","500084","Near church");
		
		assertNotNull(employeeService.addNeedyPerson(dto));
		
	}
	
	@Test
	public void testViewNeedyPeople2() throws DuplicateNeedyPersonException, InValidDetailsException{
		NeedyPeopleDto dto = new NeedyPeopleDto("Siri","1234567891",5000.0,"siri4@gmail.com","sirI@237","Hyderabad","telangana","500084","Near church");
		
		
		assertThrows(DuplicateNeedyPersonException.class,()-> employeeService.addNeedyPerson(dto));
		
	}
	
	@Test
	public void testViewNeedyPeople3() throws DuplicateNeedyPersonException, InValidDetailsException{
		NeedyPeopleDto dto = new NeedyPeopleDto("Siri","1234567891",5000.0,"siri4@gmail.com","sirI237","Hyderabad","telangana","500084","Near church");
		
		
		assertThrows(DuplicateNeedyPersonException.class,()-> employeeService.addNeedyPerson(dto));
		
	}
}