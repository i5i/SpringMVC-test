package net.java.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.dao.OrgDAO;
import net.java.spring.model.ListRequest;
import net.java.spring.model.Org;

public class ListServiceImpl implements ListService {
	@Autowired
	private OrgDAO orgDao;
	/* (non-Javadoc)
     * @see net.testapp.service.ListService#setDefaults(net.testapp.model.ListSearchData)
     */
	@Override
    public ListRequest setDefaults(ListRequest listloader){
			int perpage=10;
			String[] listheaders={"Nimi","Tüüp","Asukoht", "Keskmine hinne", "Kordi hinnatud"};
			if(listloader.getHeaders()==null){listloader.setHeaders(listheaders);}
			if(listloader.getPerpage()==0){listloader.setPerpage(perpage);}
			return listloader;
		}
	/* (non-Javadoc)
     * @see net.testapp.service.ListService#getView(net.testapp.model.ListSearchData, int, java.lang.String, org.springframework.web.servlet.ModelAndView)
     */
	@Override
    public ModelAndView getView(ListRequest listSearchData, int Page, String type, ModelAndView model){
		String sortby=listSearchData.getSortby();
		String search;
		if(listSearchData.getSearch()==null){search="";}else{search=listSearchData.getSearch();}
		List<Org> listOrgs= orgDao.list(sortby,listSearchData.getAsc(), search, type);	    
		listSearchData.setItemcount(listOrgs.size());
		//System.out.println(listLoader.toString());
		model.addObject("OrgListInfo", listSearchData); 
		model.addObject("OrgList", listOrgs);
		return model;	
	}
}
