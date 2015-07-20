/**
 * 
 */
package com.pasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pasm.service.ContactService;

/**
 * @author Peter
 *
 */
@Controller
public class ContactController {
	
	private ContactService contactService;

	@Autowired(required = true)
	@Qualifier(value = "contactService")
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String intialListArticles(Model model) {
/*		List<Article> articles = articleService.listArticles(0);
		model.addAttribute("listArticles", articles);
		model.addAttribute("rowValue", articles.size());*/
		return "contact";
	}

}
