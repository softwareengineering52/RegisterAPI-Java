package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeDeleteCommand implements VoidCommandInterface {
	@Override
	public void execute() {
		EmployeeEntity employeeEntity = this.employeeRepository.get(this.employee_id);
		if (employeeEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Employee");
		}
		
		employeeEntity.delete();
	}

	//Properties
	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	public EmployeeDeleteCommand setEmployee_ID(int employee_id) {
		this.employee_id = employee_id;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeDeleteCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeDeleteCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}

