package com.teja.mvc;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.teja.mvc.entity.Contact;
import com.teja.mvc.entity.User;
import com.teja.mvc.service.UserContactService;



@Controller
public class HelloController {
	
	@Autowired
	private UserContactService userContactService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(Principal principal,HttpSession session) {

		ModelAndView model = new ModelAndView();
		
		String name = principal.getName(); //get logged in username
	    
		session.setAttribute("username", name);
		
		
		
		model.setViewName("home");
		return model;

	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homepage() {
		

		return "home";
	}
	
	
	@ModelAttribute("user")
	public User constructUser(){
		
		return new User();
	}
	
	@ModelAttribute("contact")
	public Contact constructcontact(){
		
		return new Contact();
	}
	@RequestMapping(value = "/contactlist", method = RequestMethod.GET)
	public ModelAndView listingContactList(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		User user1=userContactService.getUpdatedContactList(user.getUserId());
		ModelAndView mv=new ModelAndView("contact");
		mv.addObject("userList",user1);
		return mv;
	}
	
	@RequestMapping(value = "/addcontact", method = RequestMethod.GET)
	public String displayContactPage() {
		

		return "addcontact";
	}
	
	@RequestMapping(value = "/addcontact", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("Contact") Contact c,HttpSession session) {
		
		User user=(User)session.getAttribute("user");
		System.out.println("User object from session"+user);
		c.setUser(user);
		userContactService.saveContact(c);

		return "savedcontact";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping("/users")
	public ModelAndView getUsers(){
		
		ModelAndView mv=new ModelAndView("users");
		
		List<User> userlist=userContactService.findAllUsers();
		mv.addObject("users",userlist);
		
		return mv;
		
	}
	@RequestMapping("/register")
	public String showRegister(Model model){
		//model.addAttribute("user", userservice.getById(id));
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(Model model){
		//model.addAttribute("user", userservice.getById(id));
		return "loginpage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String homepage(Model model,Principal principal){
		
		
		String name = principal.getName(); //get logged in username
	    model.addAttribute("username", name);
		
		System.out.println("The name is "+name);
		
		return "home";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		//model.addAttribute("user", userservice.getById(id));
		//userservice.save(user);
		userContactService.register(user);
		return "register";
	}
	@RequestMapping("/statusblock/{id}")
	@Transactional
	public ModelAndView ChangeStatus(@PathVariable int id){
		
		ModelAndView mv=new ModelAndView("users");
		
		List<User> contactList=userContactService.updateLoginStatus(id);
		mv.addObject("users",contactList);
		
		return mv;
		
	}
	@RequestMapping("/statusunblock/{id}")
	@Transactional
	public ModelAndView ChangeStatusunblock(@PathVariable int id){
		
		ModelAndView mv=new ModelAndView("users");
		
		List<User> contactList=userContactService.updateLoginStatusUnblock(id);
		mv.addObject("users",contactList);
		
		return mv;
		
	}
	@RequestMapping("/users/{id}")
	@Transactional
	public ModelAndView getUsersById(@PathVariable int id){
		
		ModelAndView mv=new ModelAndView("contact");
		
		User contactList=userContactService.findContactsById(id);
		//System.out.println("The size is"+contactList);
		mv.addObject("userList",contactList);
		return mv;
		
	}
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	 public String accessDenied(ModelMap model, Principal principal) {
	  String username = principal.getName();
	  model.addAttribute("message", "Sorry "+username+" You don't have privileges to view this page!!!");
	  return "403";
	 }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public ModelAndView logout(ModelAndView model, Principal principal,HttpSession session) {
		//HttpSession sessio
		session.invalidate();
		model.setViewName("loginpage");
	  return model;
	 }
}