package com.Akanksha.ERetailProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="productlist")
public class ProductDetails {

	@Id
	@Column(name="id")
	private int productID;
	
	@Column(name="productname")
	@NotNull(message="productName should not be null please enter valid product name!")
	//@NotBlank(message="productName should not be blank please enter valid product name!")
	//@NotEmpty(message="productName should not be empty please enter valid name!")
	@Size(min=2,message="product name should be atleast 2 characters")
	private String productName;
	
	@Column(name="categoryid")
	@NotNull(message="categoryId should not be null please enter valid category Id!")
	private int categoryID;
	
	@NotNull(message="price should not be null please enter valid price!")
	@Column(name="price")
	private double price;
	
	public ProductDetails() {
		super();
	}

	/**
	 * @param productID
	 * @param productName
	 * @param categoryID
	 * @param price
	 */
	public ProductDetails(int productID, String productName, int categoryID, double price) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.categoryID = categoryID;
		this.price = price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
