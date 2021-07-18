package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.NeedyPeopleDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

public interface NeedyPeopleService {
	public NeedyPeople registerNeedyPerson(NeedyPeopleDto needyPersonDto)
			throws InValidDetailsException, DuplicateNeedyPersonException;

	public boolean login(NeedyPeople person);

	public boolean requestForHelp(NeedyPeople person);

	boolean requestForHelp(NeedyPeopleDto person) throws NoSuchNeedyPeopleException;

	
	
	public List<Request> findRequestById(Integer needyId) throws NoSuchRequestException;
	
	public Request requestForHelp(RequestDto req) throws NoSuchNeedyPeopleException;


}
