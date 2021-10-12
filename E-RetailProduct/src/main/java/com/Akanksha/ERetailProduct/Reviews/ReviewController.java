package com.Akanksha.ERetailProduct.Reviews;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Akanksha.ERetailProduct.ProductDetails;
import com.Akanksha.ERetailProduct.ProductService;
import com.Akanksha.ERetailProduct.ExceptionHandling.ProductNotFoundException;
import com.Akanksha.ERetailProduct.ExceptionHandling.ReviewNotFoundException;
import com.Akanksha.ERetailProduct.ExceptionHandling.UserNotFoundException;
import com.Akanksha.ERetailProduct.UserInfo.User;
import com.Akanksha.ERetailProduct.UserInfo.UserService;

@RestController
@RequestMapping("/e-retail")
@Validated
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/getAllReviews")
	public ResponseEntity<List<Review>> getAllReviews(){
		try {
			List<Review> reviews=reviewService.fetchAllReviews();
			return new ResponseEntity<List<Review>>(reviews,HttpStatus.FOUND);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getReviews/{productid}")
	public ResponseEntity<List<String>> getReviewByProductId(@PathVariable(value="productid") int id){
		
			ProductDetails product=productService.fetchProductById(id);
			User user=null;
			if (product==null)
			      throw new ProductNotFoundException("id-" + id);
			else {
				
				List<String> newReviewList = new ArrayList<>();
				List<Review> reviews=reviewService.fetchAllReviews();
				
				for(Review review:reviews) {
					
					if(review.getProductID()==product.getProductID()) {
						user=userService.fetchUserById(review.getUserID());
					
						newReviewList.add(user.getUserName());
						newReviewList.add(review.getReviewSummery());
					}
				}
				return new ResponseEntity<List<String>>(newReviewList,HttpStatus.FOUND);
			}
	}
	
	@GetMapping("/getreviews/{userid}")
	public ResponseEntity<List<String>> getReviewByUserId(@PathVariable(value="userid") int id){
		
			User user=userService.fetchUserById(id);
			ProductDetails product=null;
			if (user==null)
			      throw new UserNotFoundException("id-" + id);
			else {
				
				List<String> newReviewList = new ArrayList<>();
				List<Review> reviews=reviewService.fetchAllReviews();
				
				for(Review review:reviews) {
					
					if(review.getUserID()==user.getUserId()) {
						
						product=productService.fetchProductById(review.getProductID());
					
						newReviewList.add(product.getProductName());
						newReviewList.add(review.getReviewSummery());
					}
				}
				return new ResponseEntity<List<String>>(newReviewList,HttpStatus.FOUND);
			}
	}
	
	@PostMapping("/addreview")
	public ResponseEntity<Review> addReview( @Valid @RequestBody Review review) {
		try {
		    review=reviewService.addReview(review);
			return new ResponseEntity<Review>(review,HttpStatus.CREATED);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/editreview/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable(value="id") int reviewId ,
										 @Valid @RequestBody Review review) {
		
			Review existReview=reviewService.fetchReviewById(reviewId);
			
			if(existReview==null)
				throw new ReviewNotFoundException("id-" + reviewId);
			else {
			
				existReview.setUserID(review.getUserID());
				existReview.setProductID(review.getProductID());
				existReview.setReviewSummery(review.getReviewSummery());
			
				Review update_review=reviewService.updateReview(existReview);
				return new ResponseEntity<Review>(update_review,HttpStatus.OK);
			}
	}
	
	@DeleteMapping("/deletereview/{id}")
	public ResponseEntity<Review> deleteReview(@PathVariable(value="id") int id) {
		
		Review review=null;
		review=reviewService.fetchReviewById(id);
		
		if(review==null)
			throw new ReviewNotFoundException("id-" + id);
		else {
			reviewService.deleteReview(review);
			return new ResponseEntity<Review>(review,HttpStatus.OK);
		}
	}

}
