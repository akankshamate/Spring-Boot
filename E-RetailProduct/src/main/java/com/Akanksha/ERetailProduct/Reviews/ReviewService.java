package com.Akanksha.ERetailProduct.Reviews;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ReviewService {
	@Autowired
	 ReviewRepository reviewRep;
	
	
	public List<Review> fetchAllReviews(){
		return reviewRep.findAll();
	}
	
	public Review fetchReviewById(int id) {
		List<Review> reviews=reviewRep.findAll();
		Review review=null;
		
		for(Review i:reviews) {
			if(i.getReviewID()==id)
				review=i;
		}
		return review;
	}
	
	public Review addReview(Review review) {
		
		int id=getMaxId();
		review.setReviewID(id);
		reviewRep.save(review);
		reviewRep.getById(id);
 		return review;
	}
	
	public int getMaxId() {
		return reviewRep.findAll().size()+1;
	}
	
	public Review updateReview(Review review) {
		reviewRep.save(review);
		return review;
	}
	
	public void deleteReview(Review review) {
		reviewRep.delete(review);
	}
}
