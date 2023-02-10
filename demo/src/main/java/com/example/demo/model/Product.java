package com.example.demo.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Products")
public class Product {

	public Product(long id, @NotBlank(message = "title should not be blank") @NotNull String title,
			@NotBlank(message = "description should not be blank") @NotNull String description, @Min(1) double price,
			@Min(1) int stocks, @NotBlank(message = "brand should not be blank") @NotNull String brand,
			@NotBlank(message = "category should not be blank") @NotNull String category,
			@NotBlank(message = "image should not be blank") @NotNull String images) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.stocks = stocks;
		this.brand = brand;
		this.category = category;
		this.images = images;
	}
	@Transient
	public static final String SEQUENCE_NAME = "products_sequence";
	@Id
	private long id;
	@NotBlank(message="title should not be blank")
	@NotNull
	private String title;
	@NotBlank(message="description should not be blank")
	@NotNull
	private String description;
	@Min(1)
	private double price;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", stocks=" + stocks + ", brand=" + brand + ", category=" + category + ", images=" + images + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	@Min(1)
	private int stocks;
	@NotBlank(message="brand should not be blank")
	@NotNull
	private String brand;
	@NotBlank(message="category should not be blank")
	@NotNull
	private String category;
	@NotBlank(message="image should not be blank")
	@NotNull
	private String images;
}
