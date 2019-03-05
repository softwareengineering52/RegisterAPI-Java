package edu.uark.models.repositories.interfaces;

import java.util.UUID;

import edu.uark.dataaccess.repository.BaseRepositoryInterface;
import edu.uark.models.entities.EmployeeEntity;

public interface EmployeeRepositoryInterface extends BaseRepositoryInterface<EmployeeEntity> {
	EmployeeEntity byRecord_ID(UUID record_id);
}
