package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.ILoginRepository;
import com.capgemini.dto.EmployeeDto;
import com.capgemini.exception.DuplicateEmployeeException;
import com.capgemini.exception.InValidDetailsException;
import com.capgemini.exception.NoSuchEmployeeException;
import com.capgemini.model.Address;
import com.capgemini.model.Employee;
import com.capgemini.model.Login;
import com.capgemini.util.NgoPortalConstants;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ILoginRepository loginDao;


	/*
	 * 
	 * @Param employeeDto represents employeeDto instance to be passed
	 * 
	 * @Return returns Employee instance
	 * 
	 * @Throws DuplicateEmployeeException raises if optEmployee i.e. Employee
	 * instance already exists in database
	 * 
	 * @Throws InValidDetailsException raises if values in employeeDto are invalid
	 * Description this method adds Employee into database
	 * 
	 * @Author Venkat
	 * 
	 * @Date 30-5-2021
	 */
	
	@Override
	public Employee addEmployee(EmployeeDto employeeDto) throws DuplicateEmployeeException, InValidDetailsException {

		if (validateDetails(employeeDto)) {

			Employee employee = new Employee();
			Address address = new Address();
			Login login = new Login();

			Optional<Employee> optEmployee = employeeDao.findByEmail(employeeDto.getEmail());
			if (optEmployee.isPresent())
				throw new DuplicateEmployeeException(NgoPortalConstants.EMPLOYEE_EXISTS);

			employee.setEmployeeName(employeeDto.getEmployeeName());
			employee.setEmail(employeeDto.getEmail());
			employee.setPhone(employeeDto.getPhone());
			employee.setUsername(employeeDto.getUsername());
			employee.setPassword(employeeDto.getPassword());

			address.setCity(employeeDto.getCity());
			address.setState(employeeDto.getCity());
			address.setPin(employeeDto.getPin());
			address.setLandmark(employeeDto.getLandmark());

			employee.setAddress(address);
			
			login.setUserId(employeeDto.getEmployeeId());
			login.setPassword(employeeDto.getPassword());
			login.setUserName(employeeDto.getUsername());
			login.setRole(NgoPortalConstants.EMPLOYEE);

			addressDao.save(address);

			Employee emp = employeeDao.save(employee);
			System.out.println(emp.getEmployeeId());
			login.setUserId(emp.getEmployeeId());
			
			loginDao.save(login);
			
			return emp;
		} else
			throw new InValidDetailsException(NgoPortalConstants.INVALID_DETAILS);
	}
	
	/*
	 * 
	 * @Param employeeDto represents EmployeeDto instance to be passed
	 * 
	 * @Return returns boolean true if all values in EmployeeDto are valid
	 * 
	 * @Throws InValidDetailsException raises if values in employeeDto are invalid
	 * Description this method validates values given through employeeDto
	 * 
	 * @Author Pranitha Sirigiri
	 * 
	 * @Date 30-5-2021
	 */
	

	public boolean validateDetails(EmployeeDto employeeDto) throws InValidDetailsException {

		if (!employeeDto.getEmployeeName().matches(NgoPortalConstants.NAME_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_NAME);

		if (!employeeDto.getEmail().matches(NgoPortalConstants.EMAIL_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_EMAIL);

		if (!employeeDto.getPhone().matches(NgoPortalConstants.PHONE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PHONE);

		if (!employeeDto.getUsername().matches(NgoPortalConstants.USERNAME_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_USERNAME);

		if (!employeeDto.getPassword().matches(NgoPortalConstants.PASSWORD_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PASSWORD);

		if (!employeeDto.getCity().matches(NgoPortalConstants.CITY_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_CITY);

		if (!employeeDto.getState().matches(NgoPortalConstants.STATE_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_STATE);

		if (!employeeDto.getPin().matches(NgoPortalConstants.PIN_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_PIN);

		if (!employeeDto.getLandmark().matches(NgoPortalConstants.LANDMARK_PATTERN))
			throw new InValidDetailsException(NgoPortalConstants.INVALID_LANDMARK);

		return true;
	}

	
	/*
	 * 
	 * @Param employeeId represents Integer value to be passed
	 * 
	 * @Return returns true if Employee is removed successfully
	 * 
	 * @Throws NoSuchEmployeeEmployeeException raises if no Employee with employeeId is found
	 * 
	 * Description this method removes Employee from database
	 * 
	 * @Author Venkat
	 * 
	 * @Date 30-5-2021
	 */
	
	@Override
	public boolean removeEmployee(int employeeId) throws NoSuchEmployeeException {

		Employee employee = employeeDao.findById(employeeId).orElse(null);
		if (employee == null)
			throw new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND);
		else {
			employeeDao.deleteById(employeeId);
			addressDao.deleteById(employee.getAddress().getAddressId());
			return true;
		}

	}
	
	/*
	 * 
	 * @Param employeeId represents Integer value to be passed
	 * 
	 * @Return returns Employee instance if Employee with employeeId is found
	 * 
	 * @Throws NoSuchEmployeeEmployeeException raises if no Employee with employeeId is found
	 * 
	 * Description this method finds Employee using employeeId
	 * 
	 * @Author Hajira Begum
	 * 
	 * @Date 30-5-2021
	 */
	

	@Override
	public Employee findEmployeeById(Integer employeeId) throws NoSuchEmployeeException {
		Optional<Employee> optEmployee = employeeDao.findById(employeeId);
		if (!optEmployee.isPresent())
			throw new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND);
		return optEmployee.get();
	}

	
	/*
	 * 
	 * @Param name represents String value to be passed
	 * 
	 * @Return returns List<Employee> if List<Employee> with name is found
	 * 
	 * @Throws NoSuchEmployeeEmployeeException raises if no List<Employee> with name
	 * is found
	 * 
	 * Description this method finds List of Employee with Employee Name as name
	 * 
	 * @Author Lavanya Reddy
	 * 
	 * @Date 30-5-2021
	 */
	
	@Override
	public List<Employee> findEmployeeByName(String name) throws NoSuchEmployeeException {
		List<Employee> employeeList = employeeDao.findByEmployeeName(name);
		if (employeeList.isEmpty())
			throw new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND);
		return employeeList;

	}
	/*
	 * 
	 * @Param no parameters are passed
	 * 
	 * @Return returns List<Employee> present
	 * 
	 * @Throws NoSuchEmployeeEmployeeException raises if no List<Employee> is found
	 * 
	 * Description this method finds List of all Employees
	 * 
	 * @Author Hajira Begum
	 * 
	 * @Date 30-5-2021
	 */
	

	@Override
	public List<Employee> findAllEmployee() throws NoSuchEmployeeException {
		List<Employee> employeeList = employeeDao.findAll();
		if (employeeList.isEmpty())
			throw new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND);
		return employeeList;
	}

	/*
	 * 
	 * @Param employeeDto represents EmployeeDto instance to be passed
	 * 
	 * @Return returns Employee instance
	 * 
	 * @Throws NoSuchEmployeeException raises if Employee is not found
	 * 
	 * Description this method modifies details of existing Employee
	 * 
	 * @Author Pranitha Sirigiri
	 * 
	 * @Date 30-5-2021
	 */
	
	@Override
	public Employee modifyEmployee(EmployeeDto employeeDto) throws NoSuchEmployeeException {

		Employee employee = employeeDao.findByEmail(employeeDto.getEmail()).orElse(null);
		Address address= new Address();
		
		if (employee != null) {

			employee.setEmail(employeeDto.getEmail());
			employee.setEmployeeName(employeeDto.getEmployeeName());
			employee.setPassword(employeeDto.getPassword());
			employee.setPhone(employeeDto.getPhone());
			employee.setUsername(employeeDto.getUsername());
			
			
			address.setCity(employeeDto.getCity());
			address.setState(employeeDto.getState());
			address.setPin(employeeDto.getPin());
			address.setLandmark(employeeDto.getLandmark());

			employee.setAddress(address);
			
			addressDao.save(address);
			return employeeDao.save(employee);
		} else
			throw new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND);

	}
	
	
	@Override
	 public void updateStatus(Integer id, EmployeeDto employeeDto)
				throws NoSuchEmployeeException{
			Employee employee = employeeDao.findById(id)
					.orElseThrow(() -> new NoSuchEmployeeException(NgoPortalConstants.EMPLOYEE_NOT_FOUND));
			if (employee != null) {
				
				employee.setStatus(employeeDto.isStatus());
				employeeDao.save(employee);
				}
			}

}
