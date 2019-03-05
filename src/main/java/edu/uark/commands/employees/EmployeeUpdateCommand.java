package edu.uark.commands.employees;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeUpdateCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		//Validations
//		if (StringUtils.isBlank(this.apiEmployee.getRecord_ID())) {
//			throw new UnprocessableEntityException("record_id");
//		}

		EmployeeEntity employeeEntity = this.employeeRepository.get(this.employee_id);
		if (employeeEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Employee");
		}
		
		this.apiEmployee = employeeEntity.synchronize(this.apiEmployee); //Synchronize any incoming changes for UPDATE to the database.
		
		employeeEntity.save(); //Write, via an UPDATE, any changes to the database.
		
		return this.apiEmployee;
	}

	//Properties
	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	public EmployeeUpdateCommand setEmployee_ID(int employee_id) {
		this.employee_id = employee_id;
		return this;
	}
	
	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeUpdateCommand setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getemployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeUpdateCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeUpdateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}