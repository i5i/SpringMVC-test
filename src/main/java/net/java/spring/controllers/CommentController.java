package net.java.spring.controllers;


import java.util.List;

import net.java.spring.dao.OrgDAO;
import net.java.spring.dao.ReviewDAO;
import net.java.spring.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Handles requests for the application comments section.
 */
@Controller
public class CommentController {
	
	//Database Access Objects for Organizations and Reviews
	@Autowired
	private OrgDAO orgDao;
	@Autowired
	private ReviewDAO reviewDao;
	
	//comment controllers 
	@RequestMapping(value="{type}/comment/{orgid}")
	public ModelAndView typecomment(@PathVariable("orgid") int orgid) {
		return comment(orgid);
	}
	@RequestMapping(value="/comment/{orgid}")
	public ModelAndView comment(@PathVariable("orgid") int orgid) {
		List<Review> listOrgs = reviewDao.list(orgid);
		ModelAndView model = new ModelAndView("comment", "Review", new Review());
		model.addObject("comList", listOrgs);
		model.addObject("Oid", orgid);
		return model;
	}
	//comment operations
    @RequestMapping(value = "{type}/comment/add/{orgid}", method = RequestMethod.POST)
    public String typeAddReview(@ModelAttribute("Review")
    Review review, BindingResult result, @PathVariable("orgid") int orgid) {
    	review.setOrg(orgid);
    	orgDao.update(orgid);
        reviewDao.addReview(review);
        return "redirect:/";
    }
    @RequestMapping(value = "comment/add/{orgid}", method = RequestMethod.POST)
    public String addReview(@ModelAttribute("Review")
    Review review, BindingResult result, @PathVariable("orgid") int orgid) {
    	review.setOrg(orgid);
        reviewDao.addReview(review);
        orgDao.update(orgid);
        return "redirect:/";
    }
    
    
}
