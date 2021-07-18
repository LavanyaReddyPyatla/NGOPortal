package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.DonorDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.Donor;
import com.capgemini.model.Request;

public interface DonorService {

	public Donor registerDonor(DonorDto donorDto) throws DuplicateDonorException, InValidDetailsException;

	public boolean login(Donor donor) throws NoSuchDonorException;

	public List<Request> findAllRequests() throws NoSuchRequestException;

	public void updateRaisedAmount(Integer id, RequestDto requestDto)
			throws NoSuchRequestException, InvalidAmountException;

}
