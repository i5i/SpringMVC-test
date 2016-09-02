package net.java.spring.controllers;


import java.util.List;

import net.java.spring.dao.OrgDAO;
import net.java.spring.dao.ReviewDAO;
import net.java.spring.model.ListRequest;
import net.java.spring.model.Org;
import net.java.spring.model.Review;
import net.java.spring.service.ListService;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * TODO:error handling for identical names 
 */

/**
 * Handles requests for the application administration page.
 */
@Controller
public class AdminController{
	
	//Database Access Objects for Organizations and Reviews
	@Autowired
	private OrgDAO orgDao;
	@Autowired
	private ReviewDAO reviewDao;
	@Autowired
	private ListService listService;
	
	//admin page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String toAdmin(){
		return "redirect:/admin/0";
	}
	
	@RequestMapping(value = "/admin/{page}")
	public ModelAndView adminPage(@ModelAttribute("pager")ListRequest listSearchData, @PathVariable("page") int page){
	    ModelAndView model=new ModelAndView("admin");
		listSearchData=listService.setDefaults(listSearchData);
	    return listService.getView(listSearchData, page, "", model);
	}
	
	//admin Org operations
    //deletion
    @RequestMapping(value = "admin/del/{orgid}")
    public String deleteOrg(@PathVariable("orgid") int orgid) {;
        orgDao.delete(orgid);
        return "redirect:/admin/0";
    }
    
    //new item form controllers
    @RequestMapping(value="/admin/addform")
	public ModelAndView addform(){
		ModelAndView model = new ModelAndView("addorg", "Org", new Org());
		return model;
	}
	
	@RequestMapping(value="/admin/editform/{orgid}")
	public ModelAndView editform(@PathVariable("orgid") int orgid) {      
        Org edit=orgDao.getById(orgid);
		ModelAndView model = new ModelAndView("addorg", "Org", edit);
		return model;
	}
	
    //adding & editing operation
    @RequestMapping(value = "admin/add")
    public String addOrg(@ModelAttribute("Org") Org org, BindingResult result){
    	try{
    		orgDao.add(org);
    	}catch(Exception e){
    		e.printStackTrace();
    		return "redirect:/admin/error/0";
    	}
	return "redirect:/admin/0";
    }
    
    @RequestMapping(value = "admin/editform/add")
    public String editOrg(@ModelAttribute("Org") Org org, BindingResult result){
    	orgDao.add(org);
    	return "redirect:/admin/0";
    }
    
    //admin Review operations
    @RequestMapping(value = "admin/comment/{orgid}")
    public ModelAndView adminComment(@PathVariable("orgid") int orgid){
    	List<Review> listOrgs = reviewDao.list(orgid);
    	ModelAndView model = new ModelAndView("admincomment", "Review", new Review());
    	model.addObject("comList", listOrgs);
    	model.addObject("Oid", orgid);
    	return model;
    }
    
    @RequestMapping(value = "admin/delrev/{revid}/{orgid}")
    public String adminCommentDel(@PathVariable("revid") int revid, @PathVariable("orgid") int orgid) {;
    reviewDao.delete(revid);
    orgDao.update(orgid);
    return "redirect:/admin/comment/"+orgid;
    }    
    
}
