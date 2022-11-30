package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;
	
	@NotNull
	private Integer userId;
	
	private LocalDateTime localDateTime;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String review;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	private Product product;
	
	
	private Double rating;
	
}
