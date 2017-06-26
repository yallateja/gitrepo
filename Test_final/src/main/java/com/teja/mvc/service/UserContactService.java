package com.teja.mvc.service;

import java.util.List;




import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teja.mvc.entity.Contact;
import com.teja.mvc.entity.User;
import com.teja.mvc.repository.ContactRepository;
import com.teja.mvc.repository.UserRepository;



@Service
@Transactional
public class UserContactService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	public void addUser(User u) {

		userRepository.save(u);

	}
	
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		user.setLoginStatus(1);
		user.setRole(2);
		userRepository.save(user);
	}
	@Transactional
	public User findContactsById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	public User validateLogin(String name,String password) {
		
		User user=userRepository.QuerOne(name, password);
		
		if(user==null){
			return null;
		}
		return user;
	}

	public void saveContact(Contact c) {
		// TODO Auto-generated method stub
		contactRepository.save(c);
		
	}

	public User getUpdatedContactList(Integer userId) {
		return userRepository.findOne(userId);
		
	}

	public List<User> updateLoginStatus(int id) {
		// TODO Auto-generated method stub
		
		User u=userRepository.findOne(id);
		if(u.getLoginStatus()==1){
		u.setLoginStatus(2);
		}		
		userRepository.save(u);
		List<User> u1=userRepository.findAll();
		return u1;
	}

	public List<User> updateLoginStatusUnblock(int id) {
		// TODO Auto-generated method stub
		User u=userRepository.findOne(id);
		if(u.getLoginStatus()==2){
		u.setLoginStatus(1);
		}
		userRepository.save(u);
		List<User> u1=userRepository.findAll();
		return u1;
	}
	

	

	

}
