package net.java.spring;


import java.util.List;

import net.java.spring.dao.OrgDAO;
import net.java.spring.dao.ReviewDAO;
import net.java.spring.model.Org;
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
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private OrgDAO orgDao;
	@Autowired
	private ReviewDAO reviewDao;
	private int pagecount=10;
	
	//admin page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String toAdmin() {
		return "redirect:/admin/0";
	}
	
	@RequestMapping(value = "/admin/{page}")
	public ModelAndView adminPage(@ModelAttribute("pager") PageLoader pager,@PathVariable("page") int page) {
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		String sortby;
		if(pager.getSortby()==null){sortby="name"; pager.setSortby(sortby);}else{sortby=pager.getSortby();}
		sortby=pager.getSortby();
		pager.setPage(page);
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby);}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch());
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    ModelAndView model = new ModelAndView("admin");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
	}
	@RequestMapping(value="/admin/{page}", method = RequestMethod.POST)
	public ModelAndView adminiPage(@ModelAttribute("pager") PageLoader pager){
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		String sortby=pager.getSortby();
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby,pager.getAsc());}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch());
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    ModelAndView model = new ModelAndView("admin");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
		
	}
	//homepage
	
	@RequestMapping(value="/")
	public String home0(){
		return "redirect:/0";
	}

	@RequestMapping(value="/{page}", method = RequestMethod.POST)
	public ModelAndView homi(@ModelAttribute("pager") PageLoader pager){
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		String sortby=pager.getSortby();
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby,pager.getAsc());}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch());
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    ModelAndView model = new ModelAndView("home");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
		
	}
	@RequestMapping(value="/{page}")
	public ModelAndView home(@ModelAttribute("pager") PageLoader pager,@PathVariable("page") int page){
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		String sortby;
		if(pager.getSortby()==null){sortby="name"; pager.setSortby(sortby);}else{sortby=pager.getSortby();}
		sortby=pager.getSortby();
		pager.setPage(page);
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby);}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch());
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    ModelAndView model = new ModelAndView("home");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
	}
	
	//type filtering

	@RequestMapping(value="/{type}/{page}")
	public ModelAndView hometype(@ModelAttribute("pager") PageLoader pager, @PathVariable("type") String type, @PathVariable("page") int page) {
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		
		String sortby;
		if(pager.getSortby()==null){sortby="name"; pager.setSortby(sortby);}else{sortby=pager.getSortby();}
		pager.setPage(page);
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby,pager.getAsc(),"",type);}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch(), type);
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    pager.setType(type);
	    ModelAndView model = new ModelAndView("home");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
	}
	@RequestMapping(value="/{type}/{page}", method = RequestMethod.POST)
	public ModelAndView homitype(@ModelAttribute("pager") PageLoader pager, @PathVariable("type") String type) {
		if(pager==null){pager=new PageLoader(); pager.setSortby("name");}
		String sortby=pager.getSortby();
		List<Org> listOrgs ;
		if(pager.getSearch()==null){listOrgs = orgDao.list(sortby,pager.getAsc(),"",type);}else{
			listOrgs= orgDao.list(sortby,pager.getAsc(), pager.getSearch());
		}
	    System.out.print(listOrgs);
	    if(listOrgs.size()%pagecount!=0){
	    pager.setMaxpage((listOrgs.size()/pagecount)+1);}else{
	    pager.setMaxpage((listOrgs.size()/pagecount));	
	    }
	    pager.setType(type);
	    ModelAndView model = new ModelAndView("home");
		model.addObject("pager", pager); 
		model.addObject("userList", listOrgs);
		return model;
	}
	
	
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
    
    //admin Org operations
    //deletion
    @RequestMapping(value = "admin/del/{orgid}")
    public String deleteOrg(@PathVariable("orgid") int orgid) {;
        orgDao.delete(orgid);
        return "redirect:/admin/0";
    }
    //form controllers
	@RequestMapping(value="/admin/addform")
	public ModelAndView addform() {
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
    public String addOrg(@ModelAttribute("Org")
    Org org, BindingResult result) {
    orgDao.add(org);
	return "redirect:/admin/0";
    }
    @RequestMapping(value = "admin/editform/add")
    public String editOrg(@ModelAttribute("Org")
    Org org, BindingResult result) {
    orgDao.add(org);
	return "redirect:/admin/0";
    }
    //admin Review operations
    @RequestMapping(value = "admin/comment/{orgid}")
    public ModelAndView adminComment(@PathVariable("orgid") int orgid) {;
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
