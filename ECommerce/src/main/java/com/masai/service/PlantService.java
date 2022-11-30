package com.masai.service;

import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.GetProductsDto;
import com.masai.model.Product;

public interface PlantService {

	public Product addProduct(Product product);
	
	public Product changeProductPrice(Integer productId,Double newPrice) throws ProductException;
	
	public Product changeQuantity(Integer productId,Integer newQuantity) throws ProductException;
	
	public Product updateProduct(Integer productId,Product product) throws ProductException;
	
	public List<GetProductsDto> getAllProduct() throws ProductException;
	
	public Product deleteProduct(Integer productId) throws ProductException;
	
	public List<GetProductsDto> getProductsByProductType(String productType) throws ProductException;
	
	public Product getProductDetailsByProductId(Integer productId) throws ProductException;
	
	public List<GetProductsDto> sortProductsLowToHighByPrice() throws ProductException;
	
	public List<GetProductsDto> sortProductsHighToLowByPrice() throws ProductException;
	
	
	
	
	
}
