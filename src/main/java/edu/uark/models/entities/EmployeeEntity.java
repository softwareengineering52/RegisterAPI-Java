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
		//this.record_id = rs.get(EmployeeFieldNames.RECORD_ID);
		
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
	private String last_name;
	public String getLastName() {
		return this.last_name;
	}
	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	private String active_inactive;
	public String getActive_Inactive() {
		return this.active_inactive;
	}
	public EmployeeEntity setEmployee_ID(int employee_id) {
		if (this.employee_id != employee_id) {
			this.employee_id = employee_id;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}

//	private UUID record_id;
//	public UUID getRecord_ID() {
//		return this.record_id;
//	}
//	public EmployeeEntity setRecord_ID(UUID record_id) {
//		if (this.record_id != record_id) {
//			this.record_id = record_id;
//			this.propertyChanged(EmployeeFieldNames.RECORD_ID);
//		}
//		
//		return this;
//	}

	private String password;
	public String getPassword() {
		return this.password;
	}
	private String manager;
	public String getManager() {
		return this.manager;
	}
	
	public Employee synchronize(Employee apiEmployee) {
		this.setFirstName(apiEmployee.getFirstName());
		
		apiEmployee.setRecord_ID(this.getRecord_ID());
		
		apiEmployee.setCreatedOn(this.getCreatedOn());
		//this.setCreatedOn(this.getCreatedOn());
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
		//this.record_id = null;		
		
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
		//this.record_id = apiEmployee.getRecord_ID();
	}
}
