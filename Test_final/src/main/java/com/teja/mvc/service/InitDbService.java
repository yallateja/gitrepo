package com.teja.mvc.service;

import javax.annotation.PostConstruct;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.teja.mvc.entity.Contact;
import com.teja.mvc.entity.User;



@Repository
public class InitDbService {
	@Autowired
	private UserContactService userContactService;
	
	@PostConstruct
	public void init(){
		
//		User user =new User();
//		user.setName("Yalla Teja");
//		user.setLoginName("teja");
//		user.setPassword("teja");
//		user.setRole(2);
//		user.setLoginStatus(1);
//		user.setEmail("yallateja@gmail.com");
//		user.setPhone("9705943292");
//		user.setAddress("VKI");
//		
//		
//		Contact contact=new Contact();
//		contact.setName("dikshi");
//		contact.setEmail("yalladikshi@gmail.com");
//		contact.setRemarks("my daughter");
//		contact.setPhone("9640688978");
//		
//		Contact contact1=new Contact();
//		contact1.setName("neela");
//		contact1.setEmail("yallaneela@gmail.com");
//		contact1.setRemarks("my wife");
//		contact1.setPhone("9640688978");	
//		
//		
//		user.getContactList().add(contact);
//		user.getContactList().add(contact1);
//		contact.setUser(user);
//		contact1.setUser(user);
//		
//		
//		userContactService.addUser(user);
		
	}

}
