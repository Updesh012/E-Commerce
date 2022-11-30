package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ProductException;
import com.masai.model.GetProductsDto;
import com.masai.model.Product;
import com.masai.service.PlantService;



@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private PlantService pService;
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		Product productObj = pService.addProduct(product);
		
		return new ResponseEntity<Product>(productObj,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/{id}/{price}")
	public ResponseEntity<Product> changePriceOfProductById(@PathVariable("id") Integer productId,@PathVariable("price") Double newPrice) throws ProductException{
		
		Product product = pService.changeProductPrice(productId, newPrice);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/changeQuantity/{id}/{quantity}")
	public ResponseEntity<Product> changeQuantityOfProductById(@PathVariable("id") Integer productId,@PathVariable("quantity") Integer newQuantity) throws ProductException{
		
		Product product = pService.changeQuantity(productId, newQuantity);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Product> updatePlantByIdHandler(@PathVariable("id") Integer productId,@RequestBody Product product) throws ProductException{
		
		Product productObj = pService.updateProduct(productId, product);
		
		return new ResponseEntity<Product>(productObj,HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<GetProductsDto>> getAllProductsDetails() throws ProductException{
		
		List<GetProductsDto> products = pService.getAllProduct();
		
		return new ResponseEntity<List<GetProductsDto>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("id") Integer productId) throws ProductException{
		
		Product product = pService.deleteProduct(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/byproductType/{producttype}")
	public ResponseEntity<List<GetProductsDto>> getProductsByProductTypeHandler(@PathVariable("producttype") String productType) throws ProductException{
		
		List<GetProductsDto> products = pService.getProductsByProductType(productType);
		
		return new ResponseEntity<List<GetProductsDto>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<Product> getProductDetailsByProductIdHandler(@PathVariable("productId") Integer productId) throws ProductException{
		
		Product product = pService.getProductDetailsByProductId(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}

	@GetMapping("/sortLowToHigh")
	public ResponseEntity<List<GetProductsDto>> sortProductsLowToHighByPriceHandler() throws ProductException{
		
		List<GetProductsDto> products = pService.sortProductsLowToHighByPrice();
		
		return new ResponseEntity<List<GetProductsDto>>(products,HttpStatus.OK);
	}
	
	
	@GetMapping("/sortHighToLow")
	public ResponseEntity<List<GetProductsDto>> sortProductsHighToLowByPriceHandler() throws ProductException{
		
		List<GetProductsDto> products = pService.sortProductsHighToLowByPrice();
		
		return new ResponseEntity<List<GetProductsDto>>(products,HttpStatus.OK);
	}
	
	
	
	
	
	
}
