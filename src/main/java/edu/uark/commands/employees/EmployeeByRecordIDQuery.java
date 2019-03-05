package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;


// 2.4 (3)
public class EmployeeByRecordIDQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		EmployeeEntity employeeEntity = this.employeeRepository.byRecord_ID(this.record_id);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private UUID record_id;
	public UUID getRecord_ID() {
		return this.record_id;
	}
	public EmployeeByRecordIDQuery setRecord_ID(UUID record_id) {
		this.record_id = record_id;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
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