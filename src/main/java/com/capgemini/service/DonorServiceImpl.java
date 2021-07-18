package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.DonorDao;
import com.capgemini.dao.ILoginRepository;
import com.capgemini.dao.RequestDao;
import com.capgemini.dto.DonorDto;
import com.capgemini.dto.RequestDto;
import com.capgemini.exception.DuplicateDonorException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.InvalidAmountException;
import com.capgemini.exception.NoSuchDonorException;
import com.capgemini.exception.NoSuchRequestException;
import com.capgemini.model.Address;
import com.capgemini.model.Donor;
import com.capgemini.model.Login;
import com.capgemini.model.Request;
import com.capgemini.util.NgoPortalConstants;

@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorDao donorDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private RequestDao requestDao;
	@Autowired
	private ILoginRepository loginDao;

	/*
	 * 
	 * @Param donotDto represents DonorDto instance to be passed
	 * 
	 * @Return returns Donor instance
	 * 
	 * @Throws DuplicateDonorException raises if Donor instance which has same Email
	 * as in donorDto already exists
	 * 
	 * @Throws InValidDetailsException raises if values in donorDto are invalid
	 * Description this method registers a new Donor if Donor doesn't exist in
	 * records
	 * 
	 * @Author N.Sri Harsha, Pranitha Sirigiri
	 * 
	 * @Date 30-5-2021
	 */

	@Override
	public Donor registerDonor(DonorDto donorDto) throws DuplicateDonorException, InValidDetailsException {

		System.out.println(donorDto.getDonorName());
		if (validateDetails(donorDto)) {

			Donor donor = new Donor();
			Address address = new Address();
			Login login = new Login();

			Optional<Donor> optDonor = donorDao.findByDonorEmail(donorDto.getDonorEmail());
			if (optDonor.isPresent())
				throw new DuplicateDonorException(NgoPortalConstants.DONOR_EXISTS);

			donor.setDonorName(donorDto.getDonorName());
			donor.setDonorEmail(donorDto.getDonorEmail());
			donor.setDonorPhone(donorDto.getDonorPhone());
			donor.setDonorUsername(donorDto.getDonorUsername());
			donor.setDonorPassword(donorDto.getDonorPassword());

			address.setCity(donorDto.getCity());
			address.setState(donorDto.getState());
			address.setPin(donorDto.getPin());
			address.setLandmark(donorDto.getLandmark());

			donor.setAddress(address);
			
			
			login.setPassword(donorDto.getDonorPassword());
			login.setUserName(donorDto.getDonorUsername());
			login.setRole(NgoPortalConstants.DONOR);

			addressDao.save(address);

			Donor _donor = donorDao.save(donor);
			login.setUserId(_donor.getDonorId());
			
			loginDao.save(login);
			return _donor;
		} else
			throw new InValidDetailsException(NgoPortalConstants.INVALID_DETAILS);
	}

	/*
	 * 
	 * @Param donotDto represents DonorDto instance to be passed
	 * 
	 * @Return returns boolean true if all values in DonorDto are valid
	 * 
	 * @Throws InValidDetailsException raises if values in donorDto are invalid
	 * Description this method validates values given through donorDto
	 * 
	 * @Author N.Sri Harsha, Pranitha Sirigiri
	 * 
	 * @Date 30-5-2021
	 */

	public boolean validateDetails(DonorDto donorDto) throws InValidDetailsException {

		if (!donorDto.getDonorName().matches(NgoPortalConstants.NAME_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_NAME);

		if (!donorDto.getDonorEmail().matches(NgoPortalConstants.EMAIL_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_EMAIL);

		if (!donorDto.getDonorPhone().matches(NgoPortalConstants.PHONE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PHONE);

		if (!donorDto.getDonorUsername().matches(NgoPortalConstants.USERNAME_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_USERNAME);

		if (!donorDto.getDonorPassword().matches(NgoPortalConstants.PASSWORD_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PASSWORD);

		if (!donorDto.getCity().matches(NgoPortalConstants.CITY_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_CITY);

		if (!donorDto.getState().matches(NgoPortalConstants.STATE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_STATE);

		if (!donorDto.getPin().matches(NgoPortalConstants.PIN_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PIN);

		if (!donorDto.getLandmark().matches(NgoPortalConstants.LANDMARK_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_LANDMARK);

		return true;
	}

	@Override
	public boolean login(Donor donor) throws NoSuchDonorException {
		return false;
	}

	@Override
	public List<Request> findAllRequests() throws NoSuchRequestException {
		List<Request> requestList = requestDao.findAll();
		if (requestList.isEmpty())
			throw new NoSuchRequestException(NgoPortalConstants.NO_REQUESTS);
		return requestList;
	}

	@Override
	public void updateRaisedAmount(Integer id, RequestDto requestDto)
			throws NoSuchRequestException, InvalidAmountException {
		Request request = requestDao.findById(id)
				.orElseThrow(() -> new NoSuchRequestException(NgoPortalConstants.NO_REQUESTS));
		if (request != null) {
			if (!requestDto.getRaised().isNaN() && requestDto.getRaised() >= 500
					&& requestDto.getRaised() <= requestDto.getGoal()) {
				request.setRaised(requestDto.getRaised());
				requestDao.save(request);
			} else
				throw new InvalidAmountException(NgoPortalConstants.INVALID_AMOUNT + requestDto.getGoal());
		}
	}

}
