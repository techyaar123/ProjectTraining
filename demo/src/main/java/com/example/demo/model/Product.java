package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Products")
public class Product {

	@Transient
	public static final String SEQUENCE_NAME = "products_sequence";
	@Id
	private long id;
	
	private String title;
	private String description;
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
	
	private int stocks;
	private String brand;
	private String category;
	private String images;
}
