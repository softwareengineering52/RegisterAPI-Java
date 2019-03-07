package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;
import edu.uark.models.entities.fieldnames.ProductFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.first_name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.last_name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.employee_id = rs.getInt(EmployeeFieldNames.EMPLOYEE_ID);
		this.active_inactive = rs.getString(EmployeeFieldNames.ACTIVE_INACTIVE);
		this.manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		//this.created_on = rs.getString(EmployeeFieldNames.CREATED_ON);
		//this.record_id = rs.getInt(EmployeeFieldNames.RECORD_ID);
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.first_name);
		record.put(EmployeeFieldNames.LAST_NAME, this.last_name);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employee_id);
		record.put(EmployeeFieldNames.ACTIVE_INACTIVE, this.active_inactive);
		record.put(EmployeeFieldNames.MANAGER, this.manager);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		//record.put(EmployeeFieldNames.CREATED_ON, this.created_on);		
		//record.put(EmployeeFieldNames.RECORD_ID, this.record_id);
		return record;
	}

	private String first_name;
	public String getFirstName() {
		return this.first_name;
	}
	public EmployeeEntity setFirstName(String first_name) {
		if (!StringUtils.equals(this.first_name, first_name)) {
			this.first_name = first_name;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}
		return this;
	}
	private String last_name;
	public String getLastName() {
		return this.last_name;
	}
	public EmployeeEntity setLastName(String last_name) {
		if (!StringUtils.equals(this.last_name, last_name)) {
			this.last_name = last_name;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}
		return this;
	}
	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	public EmployeeEntity setEmployee_ID(int employee_id) {
		if (this.employee_id != employee_id) {
			this.employee_id = employee_id;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	private String active_inactive;
	public String getActive_Inactive() {
		return this.active_inactive;
	}
	public EmployeeEntity setActive_Inactive(String active_inactive) {
		if (!StringUtils.equals(this.active_inactive, active_inactive)) {
			this.active_inactive = active_inactive;
			this.propertyChanged(EmployeeFieldNames.ACTIVE_INACTIVE);
		}
		return this;
	}
	private String manager;
	public String getManager() {
		return this.manager;
	}
	public EmployeeEntity setManager(String manager) {
		if (!StringUtils.equals(this.manager, manager)) {
			this.manager = manager;
			this.propertyChanged(EmployeeFieldNames.MANAGER);
		}
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public EmployeeEntity setPassword(String password) {
		if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		return this;
	}
//Change back if it doesnt work
	private UUID record_id;
	public UUID getRecord_ID() {
		return this.record_id;
	}
//	public EmployeeEntity setRecord_ID(UUID record_id) {
//		if (this.record_id != record_id) {
//			this.record_id = record_id;
//			this.propertyChanged(EmployeeFieldNames.RECORD_ID);
//		}
//		
//		return this;
//	}

	
	public Employee synchronize(Employee apiEmployee) {
	
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setEmployee_ID(apiEmployee.getEmployee_ID());
		this.setActive_Inactive(apiEmployee.getActive_Inactive());
		this.setManager(apiEmployee.getManager());
		this.setPassword(apiEmployee.getPassword());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		apiEmployee.setRecord_ID(this.getRecord_ID());
	
		
	
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		this.first_name = StringUtils.EMPTY;
		this.last_name = StringUtils.EMPTY;
		this.employee_id = -1;		
		this.active_inactive = StringUtils.EMPTY;
		this.manager = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		//this.created_on = StringUtils.EMPTY;
		//this.record_id = -1;		
		
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.EMPLOYEE);
		
		this.first_name = apiEmployee.getFirstName();
		this.last_name = apiEmployee.getLastName();
		this.employee_id = apiEmployee.getEmployee_ID();
		this.active_inactive = apiEmployee.getActive_Inactive();
		this.manager = apiEmployee.getManager();
		this.password = apiEmployee.getPassword();
		//this.created_on = apiEmployee.getCreatedOn();
		//change it back if this doesn't work
		//this.record_id = apiEmployee.getRecord_ID();
	}
}
