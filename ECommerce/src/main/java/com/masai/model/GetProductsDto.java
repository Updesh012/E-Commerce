package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetProductsDto {

	private Integer productId;
	
	private Double price;
	
	private String name;
	
	private String productType;
	


	public GetProductsDto(Integer productId, Double price, String name, String productType) {
		super();
		this.productId = productId;
		this.price = price;
		this.name = name;
		this.productType = productType;
	}
	
	
	
}
