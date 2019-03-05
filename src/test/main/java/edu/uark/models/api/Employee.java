package edu.uark.models.api;

import java.time.LocalDateTime;


import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String first_name;
	public String getfirstname() {
		return this.first_name;
	}
	public Employee setfirstname(String first_name) {
		this.first_name = first_name;
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
		this.passwopackage edu.uark.models.entities;

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
				this.recordID = rs.getint(EmployeeFieldNames.RECORD_ID);
				this.employee_id = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
				this.first_name = rs.getString(EmployeeFieldNames.FIRST_NAME);
				this.last_name = rs.getString(EmployeeFieldNames.LAST_NAME);
				this.active_inactive = rs.getString(EmployeeFieldNames.ACTIVE_INACTIVE);
				this.manager = rs.getString(EmployeeFieldNames.MANAGER);
				this.password = rs.getString(EmployeeFieldNames.PASSWORD);
				this.created_on = rs.getString(EmployeeFieldNames.CREATED_ON);

			}

			@Override
			protected Map<String, Object> fillRecord(Map<String, Object> record) {
				record.put(EmployeeFieldNames.RECORD_ID, this.recordID);
				record.put(EmployeeFieldNames.FIRST_NAME, this.first_name);
				record.put(EmployeeFieldNames.LAST_NAME, this.last_name);
				record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employee_id);
				record.put(EmployeeFieldNames.ACTIVE_INACTIVE, this.active_inactive);
				record.put(EmployeeFieldNames.MANAGER, this.manager);
				record.put(EmployeeFieldNames.PASSWORD, this.password);
				record.put(EmployeeFieldNames.CREATED_ON, this.created_on);

				return record;
			}

			private int recordID;
			public int getRecordID() {
				return this.recordID;
			}
			public EmployeeEntity setRecordID(int recordID) {
				if (!StringUtils.equals(this.recordID, recordID)) {
					this.recordID = recordID;
					this.propertyChanged(EmployeeFieldNames.RECORD_ID);
				}

				return this;
			}

			private String employee_id;
			public String getEmployeeID() {
				return this.employee_id;
			}
			public EmployeeEntity setEmployeeID(String employee_id) {
				if (this.employee_id != employee_id) {
					this.employee_id = employee_id;
					this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
				}

				return this;
			}

			private String first_name;
			public String getFirstName() {
				return this.first_name;
			}
			public EmployeeEntity setFirstName(String first_name) {
				if (this.first_name != first_name) {
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
				if (this.last_name != last_name) {
					this.last_name = last_name;
					this.propertyChanged(EmployeeFieldNames.LAST_NAME);
				}

				return this;
			}

			private String active_inactive;
			public String getActiveInactive() {
				return this.active_inactive;
			}
			public EmployeeEntity setActiveInactive(String active_inactive) {
				if (this.active_inactive != active_inactive) {
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
				if (this.manager != manager) {
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
				if (this.password != password) {
					this.password = password;
					this.propertyChanged(EmployeeFieldNames.PASSWORD);
				}

				return this;
			}

			private String created_on;
			public String getCreatedOn() {
				return this.created_on;
			}

			public EmployeeEntity setCreatedOn(String created_on) {
				if (this.created_on != created_on) {
					this.created_on = created_on;
					this.propertyChanged(EmployeeFieldNames.CREATED_ON);
				}

				return this;
			}

			public Employee synchronize(Employee apiEmployee) {
				this.setCount(apiEmployee.getCount());
				this.setRecordID(apiEmployee.getRecordID());

				apiEmployee.setId(this.getId());
				apiEmployee.setCreatedOn(this.getCreatedOn());

				return apiEmployee;
			}

			public EmployeeEntity() {
				super(DatabaseTable.Employee);

				this.recordID = -1;
				this.employee_id = StringUtils.EMPTY;
				this.first_name = StringUtils.EMPTY;
				this.last_name = StringUtils.EMPTY;
				this.active_inactive = StringUtils.EMPTY;
				this.manager = StringUtils.EMPTY;
				this.password = StringUtils.EMPTY;
				this.created_on = StringUtils.EMPTY;

			}

			public EmployeeEntity(Employee apiEmployee) {
				super(DatabaseTable.Employee);

				this.recordID = apiEmployee.getRecordID();
				this.employee_id = apiEmployee.getEmployeeID;
				this.first_name = apiEmployee.getFirstName;
				this.last_name = apiEmployee.getLastName;
				this.active_inactive = apiEmployee.getActiveInactive;
				this.manager = apiEmployee.getManager;
				this.password = apiEmployee.getPassword;
				this.created_on = apiEmployee.getCreatedOn;

			}
		}rd = employeeEntity.getPassword();
		this.firstname = employeeEntity.getfirstname();
		this.lastname = employeeEntity.getlasttname();
		this.manager = employeeEntity.getManager();
	}
}


