package net.java.spring.dao;


import java.util.Iterator;
import java.util.List;

import net.java.spring.model.Org;
import net.java.spring.model.Review;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class OrgDAOImpl implements OrgDAO {
	private SessionFactory sessionFactory;

	public OrgDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
    public void update(){
		@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		Float sum=0F;

		Iterator<Org> myListIterator = listUser.iterator(); 
		while (myListIterator.hasNext()) {
			Org org=myListIterator.next();
			int orgid=org.getId();
			@SuppressWarnings("unchecked")
			List<Review> listRvw = (List<Review>) sessionFactory.getCurrentSession()
					.createCriteria(Review.class).add(Restrictions.eq("org", orgid))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			 Iterator<Review> clumsy=  listRvw.iterator();
			 while(clumsy.hasNext()){
				 sum+=clumsy.next().getRate();
			 }
			 Float count=(float)listRvw.size();
             
			 if(count>0){ sum=sum/count;
			 }
			 sum=(float)Math.round(sum * 100) / 100;
			 org.setAverage(sum);
			 org.setCount(listRvw.size());  
			 sum=0F;
			 sessionFactory.getCurrentSession().save(org);
		}

    }
	@Override
	@Transactional
    public void update(int orgid){
		@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class).add(Restrictions.eq("id", orgid))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		Float sum=0F;

		Iterator<Org> myListIterator = listUser.iterator(); 
		while (myListIterator.hasNext()) {
			Org org=myListIterator.next();
			@SuppressWarnings("unchecked")
			List<Review> listRvw = (List<Review>) sessionFactory.getCurrentSession()
					.createCriteria(Review.class).add(Restrictions.eq("org", orgid))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			 Iterator<Review> clumsy=  listRvw.iterator();
			 while(clumsy.hasNext()){
				 sum+=clumsy.next().getRate();
			 }
			 Float count=(float)listRvw.size();
			 if(count>0){ sum=sum/count;}
			 sum=(float)Math.round(sum * 100) / 100;
			 org.setAverage(sum);
			 org.setCount(listRvw.size());  
			 sum=0F;
			 count=0F;
			 sessionFactory.getCurrentSession().save(org);
		}
    }

	@Override
	@Transactional
    public void delete(int orgid){
	sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Org.class, orgid));}
	@Override
	@Transactional
    public Org getById(int orgid){
  	return (Org) sessionFactory.getCurrentSession().get(Org.class, orgid);}
	@Override
	@Transactional
        public void add(Org org){
	sessionFactory.getCurrentSession().save(org);}
	
	@Override
	@Transactional
	public List<Org> list() {
       return list("name");
	}
	@Override
	@Transactional
	public List<Org> list(String sortby) {
		@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class).addOrder( Order.asc(sortby) )
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
	@Override
	@Transactional
	public List<Org> list(String sortby, Boolean asc) {
		if(asc){
			@SuppressWarnings("unchecked")
			List<Org>listUser= (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class).addOrder( Order.asc(sortby) )
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listUser;
			}else{
			@SuppressWarnings("unchecked")
			List<Org>listUser = (List<Org>) sessionFactory.getCurrentSession()
							.createCriteria(Org.class).addOrder( Order.desc(sortby) )
							.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listUser;}
		
	}
	@Override
	@Transactional
	public List<Org> list(String sortby, Boolean asc,String search) {
		if(asc){@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class).add(Restrictions.ilike("name","%"+search+"%")).addOrder( Order.asc(sortby) )
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;}else{
			@SuppressWarnings("unchecked")
			List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
					.createCriteria(Org.class).add(Restrictions.ilike("name","%"+search+"%")).addOrder( Order.desc(sortby) )
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listUser;
		}

	}
	@Override
	@Transactional
	public List<Org> list(String sortby, Boolean asc, String search, String type) {
		if(asc){@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
				.createCriteria(Org.class).add(Restrictions.eq("type",type)).add(Restrictions.ilike("name","%"+search+"%")).addOrder( Order.asc(sortby) )
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listUser;}else{@SuppressWarnings("unchecked")
		List<Org> listUser = (List<Org>) sessionFactory.getCurrentSession()
		.createCriteria(Org.class).add(Restrictions.eq("type",type)).add(Restrictions.ilike("name","%"+search+"%")).addOrder( Order.desc(sortby) )
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
         return listUser;}
	}
}
