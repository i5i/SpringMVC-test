package net.java.spring.dao;

import java.util.List;

import net.java.spring.model.Org;

public interface OrgDAO {
	public void update();
	public void update(int orgid);
	public void delete(int orgid);
	public Org getById(int orgid);
	public void add(Org org);
	public List<Org> list();
	public List<Org> list(String sortby);
	public List<Org> list(String sortby, Boolean asc);
	public List<Org> list(String sortby, Boolean asc, String search);
	public List<Org> list(String sortby, Boolean asc, String search,String type);
}
