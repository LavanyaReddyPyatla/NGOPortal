package com.capgemini.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.capgemini.service.NeedyPeopleService;
import com.capgemini.service.NeedyPeopleServiceImp;


@SpringBootTest
public class TestRegisterNeedyPeople {
	
	@Mock
	NeedyPeopleDao needyPeopleDao;
	
	@Mock
	AddressDao addressDao;
	
	@InjectMocks
	NeedyPeopleService needyPeople= new NeedyPeopleServiceImp();
	
	@BeforeEach
	public void berforeEach() {
		when(needyPeopleDao.findByPhone("1234567890")).thenReturn(Optional.of(new NeedyPeople()));
		when(needyPeopleDao.findByPhone("1234567891")).thenReturn(Optional.empty());
		when(addressDao.save(any(Address.class))).thenReturn(new Address());
		when(needyPeopleDao.save(any(NeedyPeople.class))).thenReturn(new NeedyPeople());
	}
	
	@Test
	public void testViewNeedyPeopleById() throws DuplicateNeedyPersonException, InValidDetailsException  {
		NeedyPeopleDto dto = new NeedyPeopleDto(1,"AnwarMd","1234567891",5000.0,"Hyderabad","telangana","500084","Near church");
		
		
		assertNotNull(needyPeople.registerNeedyPerson(dto));
		
	}
	
	@Test
	public void testViewNeedyPeopleById2() throws DuplicateNeedyPersonException, InValidDetailsException  {
		NeedyPeopleDto dto = new NeedyPeopleDto(1,"AnwarMd","1234567890",5000.0,"Hyderabad","telangana","500084","Near church");
		
		
		assertThrows(DuplicateNeedyPersonException.class,()-> needyPeople.registerNeedyPerson(dto));
		
	}
	
	@Test
	public void testViewNeedyPeopleById3() throws DuplicateNeedyPersonException, InValidDetailsException  {
		NeedyPeopleDto dto = new NeedyPeopleDto(1,"AnwarMd","1234567891",5000.0,"Hyderabad","telangana","50084","Near church");
		
		
		assertThrows(InValidDetailsException.class,()-> needyPeople.registerNeedyPerson(dto));
		
	}
	
	
}