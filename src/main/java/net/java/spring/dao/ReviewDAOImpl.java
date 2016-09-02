package net.java.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import net.java.spring.model.Review;

public class ReviewDAOImpl implements ReviewDAO {
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addReview(Review review){
		sessionFactory.getCurrentSession().save(review);
	}
	
	public ReviewDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
    public void delete(int revid){
	sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Review.class, revid));}
	@Override
	@Transactional
	public List<Review> list() {
		@SuppressWarnings("unchecked")
		List<Review> listUser = (List<Review>) sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}
	@Override
	@Transactional
	public List<Review> list(int orgid) {
		@SuppressWarnings("unchecked")
		List<Review> listUser = (List<Review>) sessionFactory.getCurrentSession()
				.createCriteria(Review.class).add(Restrictions.eq("org", orgid))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}


}
