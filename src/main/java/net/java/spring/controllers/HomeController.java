package net.java.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.java.spring.model.ListRequest;
import net.java.spring.service.ListService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	@Autowired
	private ListService listService;
	//homepage
	@RequestMapping(value="/")
	public String homeslash(){
		return "redirect:/0";
	}
	@RequestMapping(value="/{page}")
	public ModelAndView home(@ModelAttribute("OrgListInfo")ListRequest listSearchData, @PathVariable("page") int page){
			ModelAndView model = new ModelAndView("home");

		listSearchData=listService.setDefaults(listSearchData);
			return listService.getView(listSearchData, page, "", model);
	}
	@RequestMapping(value="/{type}/{page}")
	public ModelAndView hometype(@ModelAttribute("OrgListInfo")ListRequest listSearchData, @PathVariable("type") String type, @PathVariable("page") int page) {
		ModelAndView model = new ModelAndView("home");
		listSearchData=listService.setDefaults(listSearchData);
		return listService.getView(listSearchData, page, type, model);
	}
}
