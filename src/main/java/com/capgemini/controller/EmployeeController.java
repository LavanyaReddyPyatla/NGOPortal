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

import com.capgemini.dto.NeedyPeopleDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.dto.SuccessMessageDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;
import com.capgemini.service.EmployeeService;
import com.capgemini.util.NgoPortalConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/addneedypeople")
	public SuccessMessageDto registerNeedyPeople(@RequestBody NeedyPeopleDto needyPersonDto)
			throws InValidDetailsException, DuplicateNeedyPersonException {
		NeedyPeople needyPerson = employeeService.addNeedyPerson(needyPersonDto);
		return new SuccessMessageDto(needyPerson.getNeedyPersonId() + NgoPortalConstants.REGISTRATION_SUCCESSFUL);
	}

	
	
	@GetMapping("/find_needy_by_id/{id}")
	public NeedyPeople findNeedyPersonById(@PathVariable int id) throws NoSuchNeedyPeopleException {
		return employeeService.findNeedyPeopleById(id);
	}


	
	@GetMapping("/find_needy_by_name/{name}")
	public List<NeedyPeople> findNeedyPeopleByName(@PathVariable String name) throws NoSuchNeedyPeopleException {
		return employeeService.findNeedyPeopleByName(name);
	}

	
	@GetMapping("/find_all_needy")
	public List<NeedyPeople> findNeedyPeoplebyId() throws NoSuchNeedyPeopleException {
		return employeeService.findAllNeedyPeople();
	}
	@GetMapping("/requests")
	public List<Request> findAllRequests() throws NoSuchRequestException {
		return employeeService.findAllRequests();
	}
	
	@PutMapping("/updatestatus/{id}")
	public SuccessMessageDto updateRaisedAmount(@PathVariable("id") Integer id, @RequestBody RequestDto requestDto)
			throws NoSuchRequestException{
		employeeService.updateStatus(id, requestDto);
		return new SuccessMessageDto(NgoPortalConstants.STATUS_UPDATED);
	}
	
	@PutMapping("/update_needypeople")
	 public void update(@RequestBody NeedyPeople newneedypeople) throws NoSuchNeedyPeopleException
	 {
		 employeeService.update(newneedypeople);
	 }

}
