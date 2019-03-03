package edu.uark.models.api;

import java.time.LocalDateTime;


import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String firstname;
	public String getfirstname() {
		return this.firstname;
	}
	public Employee setfirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	private String lastname;
	public String getlastname() {
		return this.lastname;
	}
	public Employee setlastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	

	private int record_id;
	public int getrecord_id() {
		return this.record_id;
	}
	public Employee setrecord_id(int record_id) {
		this.record_id = record_id;
		return this;
	}
	
	private int employee_id;
	public int getemployee_id() {
		return this.employee_id;
	}
	public Employee setemployee_id(int employee_id) {
		this.employee_id = employee_id;
		return this;
	}

	private String active_inactive;
	public String getactive_inactive() {
		return this.active_inactive;
	}
	public Employee setactive_inactive(String active_inactive) {
		this.active_inactive = active_inactive;
		return this;
	}

	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
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
		this.firstname = "";
		this.lastname = "";
		this.manager = "";
		this.createdOn = LocalDateTime.now();
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.record_id = employeeEntity.getrecord_id();
		this.employee_id = employeeEntity.getemployee_id();
		this.createdOn = employeeEntity.getCreatedOn();
		this.password = employeeEntity.getPassword();
		this.firstname = employeeEntity.getfirstname();
		this.lastname = employeeEntity.getlasttname();
		this.manager = employeeEntity.getManager();
	}
}


