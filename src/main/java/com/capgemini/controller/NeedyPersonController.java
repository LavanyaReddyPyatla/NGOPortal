package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
import com.capgemini.service.NeedyPeopleService;
import com.capgemini.util.NgoPortalConstants;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class NeedyPersonController {
	

	@Autowired
	NeedyPeopleService needyPeopleService;
	
	@PostMapping("/registerneedypeople")
	public SuccessMessageDto registerNeedyPeople(@RequestBody NeedyPeopleDto needyPersonDto)
			throws InValidDetailsException, DuplicateNeedyPersonException {
		NeedyPeople needyPerson = needyPeopleService.registerNeedyPerson(needyPersonDto);
		return new SuccessMessageDto(needyPerson.getNeedyPersonName() + NgoPortalConstants.REGISTRATION_SUCCESSFUL);
		
		
	}
	@PostMapping("/requestforhelp")
	public SuccessMessageDto registerForHelp(@RequestBody RequestDto requestDto)
			throws InValidDetailsException, DuplicateNeedyPersonException, NoSuchNeedyPeopleException {
		Request request = needyPeopleService.requestForHelp(requestDto);
		return new SuccessMessageDto(request.getId() + NgoPortalConstants.REQUEST_SUCCESSFUL);
	}
	
	@GetMapping("/findallrequests/{needyId}")
	public List<Request> findAllRequests(@PathVariable Integer needyId) throws NoSuchRequestException {
		return needyPeopleService.findRequestById(needyId);
	}
}
