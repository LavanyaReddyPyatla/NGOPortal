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
public class EmployeeServiceImp implements EmployeeService {

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
	 * @Author Lavanya Reddy
	 * 
	 * @Date 30-5-2021
	 */

	@Override
	public NeedyPeople addNeedyPerson(NeedyPeopleDto person)
			throws InValidDetailsException, DuplicateNeedyPersonException {
		if (validateDetails(person)) {

			NeedyPeople needyPeople = new NeedyPeople();
			Address address = new Address();
			Login login = new Login();

			Optional<NeedyPeople> optNeedyPeople = needyPeopleDao.findByEmail(person.getEmail());
			if (optNeedyPeople.isPresent())
				throw new DuplicateNeedyPersonException(NgoPortalConstants.NEEDY_PERSON_REGISTERED);

			needyPeople.setNeedyPersonName(person.getNeedyPersonName());
			needyPeople.setPhone(person.getPhone());
			needyPeople.setFamilyIncome(person.getFamilyIncome());
			needyPeople.setEmail(person.getEmail());
			needyPeople.setPassword(person.getPassword());
			
			address.setCity(person.getCity());
			address.setState(person.getCity());
			address.setPin(person.getPin());
			address.setLandmark(person.getLandmark());

			needyPeople.setAddress(address);
			login.setPassword(person.getPassword());
			login.setUserName(person.getNeedyPersonName());
			login.setRole(NgoPortalConstants.NEEDY);


			addressDao.save(address);
			
		

			NeedyPeople needy = needyPeopleDao.save(needyPeople);
			
			login.setUserId(needy.getNeedyPersonId());
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

	/*
	 * 
	 * @Param needyPeopleId represents Integer value to be passed
	 * 
	 * @Return returns NeedyPeople instance
	 * 
	 * @Throws NoSuchNeedyPeopleException raises if NeedyPeople instance with
	 * needyPeople id already exists in database
	 * 
	 * @Throws InValidDetailsException raises if values in donorDto are invalid
	 * Description this method finds NeedyPeople for given needyPeopleId
	 * 
	 * @Author N.Sri Harsha
	 * 
	 * @Date 30-5-2021
	 */

	@Override
	public NeedyPeople findNeedyPeopleById(Integer needyPeopleId) throws NoSuchNeedyPeopleException {
		Optional<NeedyPeople> optNeedyPeople = needyPeopleDao.findById(needyPeopleId);
		if (!optNeedyPeople.isPresent())
			throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDY_PERSON_NOT_FOUND);
		return optNeedyPeople.get();
	}

	/*
	 * 
	 * @Param name represents String value to be passed
	 * 
	 * @Return returns List<NeedyPeople> if List<NeedyPeople> with name is found
	 * 
	 * @Throws NoSuchNeedyPeopleException raises if no List<NeedyPeople> with name
	 * is found
	 * 
	 * Description this method finds List of NeedyPeople with Name as name
	 * 
	 * @Author Anwar Mohammed
	 * 
	 * @Date 30-5-2021
	 */

	@Override
	public List<NeedyPeople> findNeedyPeopleByName(String name) throws NoSuchNeedyPeopleException {
		List<NeedyPeople> needyPeopleList = needyPeopleDao.findByNeedyPersonName(name);
		if (needyPeopleList.isEmpty())
			throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDY_PERSON_NOT_FOUND);
		return needyPeopleList;
	}

	/*
	 * 
	 * @Param no parameters are passed
	 * 
	 * @Return returns List<NeedyPeople>
	 * 
	 * @Throws NoSuchNeedyPeopleException raises if List<NeedyPeople> is not found
	 * 
	 * Description this method finds List of all NeedyPeople
	 * 
	 * @Author Pranitha
	 * 
	 * @Date 30-5-2021
	 */

	@Override
	public List<NeedyPeople> findAllNeedyPeople() throws NoSuchNeedyPeopleException {
		List<NeedyPeople> needyPeopleList = needyPeopleDao.findAll();
		if (needyPeopleList.isEmpty())
			throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDYPEOPLE_NOT_FOUND);
		return needyPeopleList;
	}
	
	@Override
	 public void updateStatus(Integer id, RequestDto requestDto)
				throws NoSuchRequestException{
			Request request = requestDao.findById(id)
					.orElseThrow(() -> new NoSuchRequestException(NgoPortalConstants.REQUEST_NOT_FOUND));
			if (request != null) {
				
					request.setStatus(requestDto.isStatus());
					requestDao.save(request);
				}
			}
	
	@Override
	 public List<Request> findAllRequests() throws NoSuchRequestException {
			List<Request> requestList = requestDao.findAll();
			if (requestList.isEmpty())
				throw new NoSuchRequestException(NgoPortalConstants.REQUEST_NOT_FOUND);
			return requestList;
		}
	
	@Override
	public void update(NeedyPeople newneedypeople) throws NoSuchNeedyPeopleException{
		Optional<NeedyPeople> needy=needyPeopleDao.findById(newneedypeople.getNeedyPersonId());
		if(needy.isPresent())
			{
			needyPeopleDao.save(newneedypeople);
			}
		else
			throw new NoSuchNeedyPeopleException(NgoPortalConstants.NEEDY_PERSON_NOT_FOUND);
	}

}
