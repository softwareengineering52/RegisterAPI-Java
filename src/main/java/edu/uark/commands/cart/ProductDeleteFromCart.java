package edu.uark.commands.cart;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.ProductEntity;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class ProductDeleteFromCart implements VoidCommandInterface {
	@Override
	public void execute() {
		ProductEntity productEntity = this.productRepository.get(this.productId);
		if (productEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Product");
		}
		
		productEntity.delete();
	}

	//Properties
	private UUID productId;
	public UUID getProductId() {
		return this.productId;
	}
	public ProductDeleteFromCart setProductId(UUID productId) {
		this.productId = productId;
		return this;
	}
	
	private ProductRepositoryInterface productRepository;
	public ProductRepositoryInterface getProductRepository() {
		return this.productRepository;
	}
	public ProductDeleteFromCart setProductRepository(ProductRepositoryInterface productRepository) {
		this.productRepository = productRepository;
		return this;
	}
	
	public ProductDeleteFromCart() {
		this.cartRepository = new CartRepository();
	}
}
