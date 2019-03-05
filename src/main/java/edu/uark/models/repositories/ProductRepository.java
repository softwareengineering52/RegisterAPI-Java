package edu.uark.models.repositories;

import java.sql.SQLException;

import edu.uark.dataaccess.repository.BaseRepository;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.dataaccess.repository.helpers.PostgreFunctionType;
import edu.uark.dataaccess.repository.helpers.SQLComparisonType;
import edu.uark.dataaccess.repository.helpers.where.WhereClause;
import edu.uark.dataaccess.repository.helpers.where.WhereContainer;
import edu.uark.models.entities.ProductEntity; //Taylor
import edu.uark.models.entities.fieldnames.ProductFieldNames; //Taylor
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;//Harris

public class ProductRepository extends BaseRepository<ProductEntity> implements ProductRepositoryInterface {
	@Override
	public ProductEntity byLookupCode(String lookupCode) {
		return this.firstOrDefaultWhere(
			new WhereContainer(
				(new WhereClause()).
					postgreFunction(PostgreFunctionType.LOWER).
					table(this.primaryTable).
					fieldName(ProductFieldNames.LOOKUP_CODE).
					comparison(SQLComparisonType.EQUALS)
			),
			(ps) -> {
				try {
					ps.setObject(1, lookupCode.toLowerCase());
				} catch (SQLException e) {}

				return ps;
			}
		);
	}
	
	@Override
	public ProductEntity createOne() {
		return new ProductEntity();
	}
	
	public ProductRepository() {
		super(DatabaseTable.PRODUCT);
	}

	@Override
	public ProductEntity get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
