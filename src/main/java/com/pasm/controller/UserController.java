/**
 * 
 */
package com.pasm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pasm.model.User;
import com.pasm.service.UserService;

/**
 * @author Peter
 * 
 */
@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService ps) {
		this.userService = ps;
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new User());
		model.addAttribute("listPersons", this.userService.listPersons());
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") User p) {
/*
		if (p.getId() == 0) {
			// new person, add it
			this.userService.addPerson(p);
		} else {
			// existing person, call update
			this.userService.updatePerson(p);
		}*/

		return "redirect:/persons";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.userService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.userService.getPersonById(id));
		model.addAttribute("listPersons", this.userService.listPersons());
		return "person";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(Model model,HttpServletRequest request,HttpSession session) {
		User user=userService.loginAction(request.getParameter("email"),request.getParameter("password"));
		if(user == null){
			return "login";
		}
		user.setPassword("");
		session.setAttribute("user", user);		
		return "redirect:/";		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest request,HttpSession session) {
		session.setAttribute("user", null);		
		return "redirect:/";		
	}
	

}
