package edu.uark.models.api;

import java.time.LocalDateTime;


import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String first_name;
	public String getFirstName() {
		return this.first_name;
	}
	public Employee setFirstName(String first_name) {
		this.first_name = first_name;
		return this;
	}

	private String last_name;
	public String getLastName() {
		return this.last_name;
	}
	public Employee setlastname(String last_name) {
		this.last_name = last_name;
		return this;
	}

	private int record_id;
	public int getRecord_ID() {
		return this.record_id;
	}
	public Employee setRecord_Id(int record_id) {
		this.record_id = record_id;
		return this;
	}
	
	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	public Employee setEmployee_ID(int employee_id) {
		this.employee_id = employee_id;
		return this;
	}

	private String active_inactive;
	public String getActive_Inactive() {
		return this.active_inactive;
	}
	public Employee setActive_Inactive(String active_inactive) {
		this.active_inactive = active_inactive;
		return this;
	}

	private LocalDateTime created_on;
	public LocalDateTime getCreatedOn() {
		return this.created_on;
	}
	public Employee setCreatedOn(LocalDateTime created_on) {
		this.created_on = created_on;
		return this;
	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}

	private String manager;
	public String getManager() {
		return this.manager;
	}
	public Employee setManager(String manager) {
		this.manager = manager;
		return this;
	}
	
	public Employee() {
		this.employee_id = -1;
		this.record_id = -1;
		this.active_inactive = "";
		this.password = "";
		this.first_name = "";
		this.last_name = "";
		this.manager = "";
		this.created_on = LocalDateTime.now();
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.first_name = employeeEntity.getFirstName();
		this.last_name = employeeEntity.getLastName();
		this.employee_id = employeeEntity.getEmployee_ID();
		this.active_inactive = employeeEntity.getActive_Inactive();
		this.manager = employeeEntity.getManager();
		this.password = employeeEntity.getPassword();
		this.created_on = employeeEntity.getCreatedOn();
		this.record_id = employeeEntity.getRecord_ID();
	}

}


