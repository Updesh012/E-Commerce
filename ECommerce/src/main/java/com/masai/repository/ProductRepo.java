package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.GetProductsDto;
import com.masai.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query("SELECT new com.masai.model.GetProductsDto(p.productId, p.price, p.name, p.productType) FROM Product p WHERE p.productType = :typ")
	public List<GetProductsDto> getAllProductsByProductType(@Param("typ") String type);
	
	@Query("SELECT new com.masai.model.GetProductsDto(p.productId, p.price, p.name, p.productType) FROM Product p")
	public List<GetProductsDto> getAllProducts();
	

}
