package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductException;
import com.masai.model.GetProductsDto;
import com.masai.model.Product;
import com.masai.repository.ProductRepo;

@Service
public class PlantServiceImpl implements PlantService{

	@Autowired
	private ProductRepo pRepo;
	
	@Override
	public Product addProduct(Product product) {
		
		Product productObj = pRepo.save(product);
		return productObj;
		
	}

	@Override
	public Product changeProductPrice(Integer productId, Double newPrice) throws ProductException {
		
		Optional<Product> opt = pRepo.findById(productId);
		
		if(opt.isPresent()) {
			
			Product product = opt.get();
			product.setPrice(newPrice);
			return pRepo.save(product);
			
		}else {
			throw new ProductException("No product found with this productId");
		}
		
		
	}

	@Override
	public Product changeQuantity(Integer productId, Integer newQuantity) throws ProductException {
		
		Optional<Product> opt = pRepo.findById(productId);
		
		if(opt.isPresent()) {
			
			Product product = opt.get();
			product.setQuantity(newQuantity);
			return pRepo.save(product);
			
		}else {
			throw new ProductException("No product found with this productId");
		}
		
	}

	@Override
	public Product updateProduct(Integer productId, Product product) throws ProductException {
		
		Optional<Product> opt = pRepo.findById(productId);
		
		if(opt.isPresent()) {
			
			return pRepo.save(product);
			
		}else {
			throw new ProductException("No product found with this productId");
		}
		
		
	}

	@Override
	public List<GetProductsDto> getAllProduct() throws ProductException {
		
		List<GetProductsDto> products = pRepo.getAllProducts();
		
		if(products.isEmpty()) {
			throw new ProductException("No product Found...");
		}else {
			
			return products;
			
		}
		
		
		
	}

	@Override
	public Product deleteProduct(Integer productId) throws ProductException {
		
		Optional<Product> opt = pRepo.findById(productId);
		
		if(opt.isPresent()) {
			pRepo.deleteById(productId);
			return opt.get();
			
		}else {
			throw new ProductException("No product found with this productId");
		}
		
		
		
		
		
	}

	@Override
	public List<GetProductsDto> getProductsByProductType(String productType) throws ProductException {
		
		List<GetProductsDto> products = pRepo.getAllProductsByProductType(productType);
		
		if(products.isEmpty()) {
			throw new ProductException("No product Found");
		}else {
			return products;
		}
		
	}

	@Override
	public Product getProductDetailsByProductId(Integer productId) throws ProductException {
		
		Optional<Product> opt = pRepo.findById(productId);
		
		if(opt.isPresent()) {
			
			return opt.get();
			
		}else {
			throw new ProductException("Product not found with this productId");
		}
		
		
	}

	@Override
	public List<GetProductsDto> sortProductsLowToHighByPrice() throws ProductException {
		
		List<GetProductsDto> products = pRepo.getAllProducts();
		
		products.sort((p1,p2) -> p1.getPrice() > p2.getPrice() ? 1 : -1);
		
		if(products.isEmpty()) {
			throw new ProductException("No Product Found...");
		}else {
			return products;
		}
		
	}
	
	
	@Override
	public List<GetProductsDto> sortProductsHighToLowByPrice() throws ProductException {
		
		List<GetProductsDto> products = pRepo.getAllProducts();
		
		products.sort((p1,p2) -> p2.getPrice() > p1.getPrice() ? 1 : -1);
		
		if(products.isEmpty()) {
			throw new ProductException("No Product Found...");
		}else {
			return products;
		}
		
	}
	

}
