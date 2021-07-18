package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.ILoginRepository;
import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.dao.RequestDao;
import com.capgemini.dto.NeedyPeopleDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.exception.DuplicateNeedyPersonException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchNeedyPeopleException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.Address;
import com.capgemini.model.Login;
import com.capgemini.model.NeedyPeople;
import com.capgemini.model.Request;
import com.capgemini.util.NgoPortalConstants;

@Service
public class NeedyPeopleServiceImp implements NeedyPeopleService {

	@Autowired
	private NeedyPeopleDao needyPeopleDao;

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private RequestDao requestDao;
	
	@Autowired
	private ILoginRepository loginDao;

	/*
	 * 
	 * @Param person represents NeedyPeopleDto instance to be passed
	 * 
	 * @Return returns NeedyPeople instance
	 * 
	 * @Throws DuplicateNeedyPersonException raises if NeedyPeople instance which
	 * has same Phone as in person already exists
	 * 
	 * @Throws InValidDetailsException raises if values in person are invalid
	 * Description this method registers a new NeedyPeople if NeedyPeople doesn't
	 * exist in records
	 * 
	 * @Author Anwar Mohammed
	 * 
	 * @Date 30-5-2021
	 */
	
	@Override
	public NeedyPeople registerNeedyPerson(NeedyPeopleDto person) throws DuplicateNeedyPersonException, InValidDetailsException {
		if (validateDetails(person)) {

			NeedyPeople needyPerson = new NeedyPeople();
			Address address = new Address();
			
			Login login = new Login();

			Optional<NeedyPeople> optNeedy = needyPeopleDao.findByPhone(person.getPhone());
			if (optNeedy.isPresent())
				throw new DuplicateNeedyPersonException(NgoPortalConstants.NEEDY_PERSON_REGISTERED);

			needyPerson.setNeedyPersonName(person.getNeedyPersonName());
			needyPerson.setPhone(person.getPhone());
			needyPerson.setFamilyIncome(person.getFamilyIncome());
			address.setCity(person.getCity());
			address.setState(person.getCity());
			address.setPin(person.getPin());
			address.setLandmark(person.getLandmark());
			needyPerson.setAddress(address);
			
			login.setUserId(person.getNeedyPersonId());
			login.setPassword(person.getPassword());
			login.setUserName(person.getNeedyPersonName());
			login.setRole(NgoPortalConstants.NEEDY);
			addressDao.save(address);
			NeedyPeople needy = needyPeopleDao.save(needyPerson);
			
			loginDao.save(login);
			
			return needy;
		} else
			throw new InValidDetailsException(NgoPortalConstants.INVALID_DETAILS);
	}

	/*
	 * 
	 * @Param person represents NeedyPeopleDto instance to be passed
	 * 
	 * @Return returns boolean true if all values in person are valid
	 * 
	 * @Throws InValidDetailsException raises if values in person are invalid
	 * Description this method validates values given through person
	 * 
	 * @Author N.Sri Harsha, Pranitha Sirigiri
	 * 
	 * @Date 30-5-2021
	 */
	
	public boolean validateDetails(NeedyPeopleDto person) throws InValidDetailsException {

		if (!person.getNeedyPersonName().matches(NgoPortalConstants.NAME_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_NAME);

		if (!person.getPhone().matches(NgoPortalConstants.PHONE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PHONE);

		if (!person.getCity().matches(NgoPortalConstants.CITY_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_CITY);

		if (!person.getState().matches(NgoPortalConstants.STATE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_STATE);

		if (!person.getPin().matches(NgoPortalConstants.PIN_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PIN);

		if (!person.getLandmark().matches(NgoPortalConstants.LANDMARK_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_LANDMARK);

		return true;
	}

	

	@Override
	public boolean requestForHelp(NeedyPeopleDto person) throws NoSuchNeedyPeopleException {

		Optional<NeedyPeople> needy = needyPeopleDao.findById(person.getNeedyPersonId());
		if (needy.isPresent())
			return true;
		else
			throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDY_PERSON_NOT_FOUND);

	}
	
	
	@Override
	public Request requestForHelp(RequestDto req) throws NoSuchNeedyPeopleException {
		Request request = new Request();
		//NeedyPeople needyPerson = new NeedyPeople();
		//Optional<NeedyPeople> needy = needyPeopleDao.findById(req.getNeedyPeopleId());
		//if (needy.isPresent()) {
			request.setTitle(req.getTitle());
			//request.setDonationType(req.getDonationType());
			request.setDescription(req.getDescription());
			
			request.setGoal(req.getGoal());
			//request.setRaised(NgoPortalConstants.ZERO);
			//needyPerson.setNeedyPersonId(req.getNeedyPeopleId());
			return requestDao.save(request);
		//}	
		//else
		//	throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDY_PERSON_NOT_FOUND);

	}
	
	@Override
	public List<Request> findRequestById(Integer needyId) throws NoSuchRequestException {
		//Request request=new Request();
		//List<NeedyPeople> needyList = needyPeopleDao.findByNeedyPersonId(needyId);
		List<Request> requestList = requestDao.findByNeedyPeopleId(needyId);
		if (requestList.isEmpty())
			throw new NoSuchRequestException(NgoPortalConstants.REQUEST_NOT_FOUND);
		return requestList;
	}

	
	
	@Override
	public boolean login(NeedyPeople person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requestForHelp(NeedyPeople person) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
