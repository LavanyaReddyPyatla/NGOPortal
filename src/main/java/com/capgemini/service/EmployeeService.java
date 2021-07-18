package com.capgemini.service;

import java.util.List;

import com.capgemini.dto.NeedyPeopleDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;

public interface EmployeeService {

	public List<NeedyPeople> findNeedyPeopleByName(String name) throws NoSuchNeedyPeopleException;

	public List<NeedyPeople> findAllNeedyPeople() throws NoSuchNeedyPeopleException;

	public NeedyPeople findNeedyPeopleById(Integer needyPeopleId) throws NoSuchNeedyPeopleException;

	public NeedyPeople addNeedyPerson(NeedyPeopleDto needy)
			throws InValidDetailsException, DuplicateNeedyPersonException;

	void updateStatus(Integer id, RequestDto requestDto) throws NoSuchRequestException;

	List<Request> findAllRequests() throws NoSuchRequestException;

	void update(NeedyPeople newneedypeople) throws NoSuchNeedyPeopleException;
}
