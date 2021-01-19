package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repository.UserRepository;

@Service
public class UserService {
	private UserRepository uRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.uRepo=userRepo;
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<User> getAll(){
		return (List<User>) uRepo.findAll();
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public User getById(int id) {
		Optional<User> _user=uRepo.findById(id);
		return _user.get();
	}
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<User> getByFirstName(String name) {
		//List<User> _user=uRepo.findByFirstName(name);
		return (List<User>) uRepo.findByName(name);
	}

 

	@Transactional
	//we probably need to add each field ex. newUser.getUsername().equals("")
	public User add(User newUser) {
		if(newUser.getFirstName().equals("")|| newUser.getLastName().equals("")) return null;
		if(newUser.getFirstName()==null|| newUser.getLastName()==null) return null;
		return uRepo.save(newUser);
	}
	@Transactional
	public User update(User updatedUser ) {
		if(updatedUser.getFirstName().equals("")|| updatedUser.getLastName().equals("")) return null;
		if(updatedUser.getFirstName()==null|| updatedUser.getFirstName()==null) return null;
		return uRepo.save(updatedUser);
	}
	
	@Transactional
	public boolean delete(int id) {
		uRepo.deleteById(id);
		User user=getById(id);
		if(user==null) return true;
		return false;
	}

}
