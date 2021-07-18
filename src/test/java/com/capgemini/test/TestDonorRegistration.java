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
import com.capgemini.dao.DonorDao;
import com.capgemini.dto.DonorDto;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.model.Address;
import com.capgemini.model.Donor;
import com.capgemini.service.DonorService;
import com.capgemini.service.DonorServiceImpl;

@SpringBootTest
class TestDonorRegistration {

	@Mock
	private AddressDao addressDao;

	@Mock
	private DonorDao donorDao;

	@InjectMocks
	private DonorService donorService = new DonorServiceImpl();

	@BeforeEach
	public void berforeEach() {
		when(donorDao.findByDonorEmail("ramesh3@gmail.com")).thenReturn(Optional.of(new Donor()));
		when(donorDao.findByDonorEmail("harsha@gmail.com")).thenReturn(Optional.empty());
		when(addressDao.save(any(Address.class))).thenReturn(new Address());
		when(donorDao.save(any(Donor.class))).thenReturn(new Donor());
	}

	@Test
	public void testAddDonor() throws DuplicateDonorException, InValidDetailsException {

	

		DonorDto dto = new DonorDto( "ramesh", "harsha@gmail.com", "9879879798", "ramesh123e", "@Ramesh123","hyd","Telangana","500006","out post");

		assertNotNull(donorService.registerDonor(dto));
	}
	
	@Test
	public void testAddDonor2() throws DuplicateDonorException, InValidDetailsException {

	

		DonorDto dto = new DonorDto( "ramesh", "ramesh3@gmail.com", "9879879798", "ramesh123e", "@Ramesh123","hyd","Telangana","500006","out post");

		assertThrows(DuplicateDonorException.class, ()->donorService.registerDonor(dto));
	}
	
	@Test
	public void testAddDonor3() throws DuplicateDonorException, InValidDetailsException {

	

		DonorDto dto = new DonorDto( "ramesh", "ramesh@gmail.com", "9879879798", "ramesh123e", "@Ramesh123","hyd","Telangana","5006","out post");

		assertThrows(InValidDetailsException.class, ()->donorService.registerDonor(dto));
	}

}
