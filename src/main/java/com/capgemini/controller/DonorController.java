package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.DonorDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.dto.SuccessMessageDto;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.Donor;
import com.capgemini.model.Request;
import com.capgemini.service.DonorService;
import com.capgemini.util.NgoPortalConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DonorController {

	@Autowired
	DonorService donorService;

	@PostMapping("/registerdonor")
	public SuccessMessageDto registerDonor(@RequestBody DonorDto donorDto)
			throws InValidDetailsException, DuplicateDonorException {
		Donor donor = donorService.registerDonor(donorDto);
		return new SuccessMessageDto(donor.getDonorId() + NgoPortalConstants.REGISTRATION_SUCCESSFUL);
	}

//	@GetMapping("/requests")
//	public List<Request> findAllRequests() throws NoSuchRequestException {
//		return donorService.findAllRequests();
//	}

	@PutMapping("/addamount/{id}")
	public SuccessMessageDto updateRaisedAmount(@PathVariable("id") Integer id, @RequestBody RequestDto requestDto)
			throws NoSuchRequestException, InvalidAmountException {
		donorService.updateRaisedAmount(id, requestDto);
		return new SuccessMessageDto(NgoPortalConstants.AMOUNT_ADDED);
	}
}
