package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
		this.employee_id = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.active_inactive = rs.getString(EmployeeFieldNames.ACTIVE_INACTIVE);
		this.manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.created_on = rs.getString(EmployeeFieldNames.CREATED_ON);
		this.record_id = rs.getint(EmployeeFieldNames.RECORD_ID);
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.first_name);
		record.put(EmployeeFieldNames.LAST_NAME, this.last_name);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employee_id);
		record.put(EmployeeFieldNames.ACTIVE_INACTIVE, this.active_inactive);
		record.put(EmployeeFieldNames.MANAGER, this.manager);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		record.put(EmployeeFieldNames.CREATED_ON, this.created_on);		
		record.put(EmployeeFieldNames.RECORD_ID, this.record_id);
		return record;
	}

	private int employee_id;
	public int getEmployee_ID() {
		return this.employee_id;
	}
	public EmployeeEntity setEmployee_ID(int Employee_ID) {
		if (!StringUtils.equals(this.employee_id, employee_id)) {
			this.employee_id = employee_id;
			this.propertyChanged(EmployeeFieldNames.LOOKUP_CODE);
		}
		
		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public EmployeeEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(EmployeeFieldNames.COUNT);
		}
		
		return this;
	}
	
	public Employee synchronize(Employee apiEmployee) {
		this.setCount(apiEmployee.getCount());
		
		this.setLookupCode(apiEmployee.getLookupCode());
		
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());
		
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.Employee);
		this.first_name = StringUtils.EMPTY;
		this.last_name = StringUtils.EMPTY;
		this.employee_id = StringUtils.EMPTY;		
		this.active_inactive = StringUtils.EMPTY;
		this.manager = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.created_on = StringUtils.EMPTY;
		this.record_id = -1;		
		
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.Employee);_
		
		this.first_name = apiEmployee.getFirstName;
		this.last_name = apiEmployee.getLastName;
		this.employee_id = apiEmployee.getEmployeeID;
		this.active_inactive = apiEmployee.getActiveInactive;
		this.manager = apiEmployee.getManager;
		this.password = apiEmployee.getPassword;
		this.created_on = apiEmployee.getCreatedOn;
		this.record_id = apiEmployee.getRecordID();
	}
}
