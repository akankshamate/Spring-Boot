package com.Akanksha.ERetailProduct.Reviews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	@Column(name="reviewid")
	private int reviewID;
	
	@Column(name="userid")
	private int userID;
	
	@Column(name="productid")
	private int productID;
	
	@Column(name="reviewsummery")
	@NotNull(message="userName should not be null or blank please enter valid user name!")
	@Size(min=2,message="product name should be atleast 2 characters")
	private String reviewSummery;
	

	public Review() {
		super();
	}

	public Review(int reviewID, int userID, int productID, String reviewSummery) {
		super();
		this.reviewID = reviewID;
		this.userID = userID;
		this.productID = productID;
		this.reviewSummery = reviewSummery;
	}

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getReviewSummery() {
		return reviewSummery;
	}

	public void setReviewSummery(String reviewSummery) {
		this.reviewSummery = reviewSummery;
	}
	
}
