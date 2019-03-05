package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeByRecordIDQuery;
import edu.uark.commands.employees.EmployeeCreateCommand;
import edu.uark.commands.employees.EmployeeDeleteCommand;
import edu.uark.commands.employees.EmployeeQuery;
import edu.uark.commands.employees.EmployeeUpdateCommand;
import edu.uark.commands.employees.EmployeesQuery;
import edu.uark.models.api.Employee;


@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return (new EmployeesQuery()).execute();
	}

	@RequestMapping(value = "/{employee_id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int employee_id) {
		return (new EmployeeQuery()).
			setEmployee_ID(employee_id).
			execute();
	}

	@RequestMapping(value = "/byrecordid/{employeeRecordID}", method = RequestMethod.GET)
	public Employee getEmployeeByRecordID(@PathVariable UUID employeeRecordID) {
		return (new EmployeeByRecordIDQuery()).
			setRecord_ID(employeeRecordID).
			execute();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return (new EmployeeCreateCommand()).
			setApiEmployee(employee).
			execute();
	}

	@RequestMapping(value = "/{employee_id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable int employee_id, @RequestBody Employee employee) {
		return (new EmployeeUpdateCommand()).
			setEmployee_ID(employee_id).
			setApiEmployee(employee).
			execute();
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable int employee_id) {
		(new EmployeeDeleteCommand()).
			setEmployee_ID(employee_id).
			execute();
	}


	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}
