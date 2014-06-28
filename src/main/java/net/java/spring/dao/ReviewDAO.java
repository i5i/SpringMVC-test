package net.java.spring.dao;

import java.util.List;

import net.java.spring.model.Review;

public interface ReviewDAO {
	public void delete(int revid);
	public void addReview(Review review);
	public List<Review> list();
	public List<Review> list(int orgid);
}
