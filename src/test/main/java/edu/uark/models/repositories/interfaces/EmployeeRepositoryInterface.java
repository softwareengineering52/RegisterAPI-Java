package edu.uark.models.repositories.interfaces;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.EmployeeEntity;

public interface EmployeeRepositoryInterface extends BaseRepositoryInterface<EmployeeEntity> {
	EmployeeEntity byEmployee_ID(String record_id);
}
