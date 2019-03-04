package edu.uark.commands.employees;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;


// 2.4 (3)
public class EmployeeByLookupCodeQuery implements ResultCommandInterface<Product> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.lookupCode)) {
			throw new UnprocessableEntityException("lookupcode");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byLookupCode(this.lookupCode);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public EmployeeCodeQuery setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	private EmployeeRepositoryInterface EmployeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeByLookupCodeQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeByLookupCodeQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}