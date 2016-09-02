package net.java.spring.service;

import org.springframework.web.servlet.ModelAndView;

import net.java.spring.model.ListRequest;

public interface ListService {

    /**
     * 
     * @param list request object 
     * @return request object with configured length and headers
     * 
     * TODO:retrive info from ini files, localization details from user preferences
     */
    ListRequest setDefaults(ListRequest listloader);

    /**
     * 
     * @param list request object
     * @param list page number 
     * @param list filtered by type
     * @param list relevant DAO 
     * @param model where list is inserted
     * @return model
     * 
     * Generates List of objects and inserts into a Model
     */
    ModelAndView getView(ListRequest listSearchData, int Page, String type, ModelAndView model);

}