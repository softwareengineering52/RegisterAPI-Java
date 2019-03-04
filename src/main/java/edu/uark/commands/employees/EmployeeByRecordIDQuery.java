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
public class EmployeeByRecordIDQuery implements ResultCommandInterface<Product> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.recordID)) {
			throw new UnprocessableEntityException("recordid");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byRecordID(this.recordID);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private String recordID;
	public String getRecordID() {
		return this.recordID;
	}
	public EmployeeCodeQuery setRecordID(String recordID) {
		this.recordID = recordID;
		return this;
	}
	
	private EmployeeRepositoryInterface EmployeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeByRecordIDQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeByRecordIDQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}