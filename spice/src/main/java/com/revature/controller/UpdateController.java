package com.revature.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.User;
import com.revature.repository.UserRepository;

@CrossOrigin(origins = { "http://localhost:4200" }, allowCredentials = "true")
@RestController
@RequestMapping("/users/update")
public class UpdateController {

	@Autowired
	private UserRepository uRepo;


	@PostMapping("/retrieve_user")
	public ResponseEntity<User> getUserById(@Valid @RequestBody int id) {
		User user = uRepo.findById(id).orElse(null);
		if (user == null) {
			return null;
		}

		return ResponseEntity.ok().body(user);
	}

	private User getByIdLocal(int id) {
		return uRepo.getOne(id);

	}


	@PostMapping("/complete")
	public ResponseEntity<User> completeUpdate(@Valid @RequestBody User updatedUser) throws ResourceNotFoundException {
		User user = getByIdLocal(updatedUser.getUserId());
		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());
		user.setBio(updatedUser.getBio());
		user.setPassword(updatedUser.getPassword());


		if (updatedUser.getProfilePicture() != null) {
			System.out.println("Updating Profile");
			String test = updatedUser.getProfilePicture();
			String set = test.substring(1, test.length() - 1);
			user.setProfilePicture(set);
		} System.out.println("Not updating profile");
		final User updatedVersion = uRepo.save(user);
		return ResponseEntity.ok(updatedVersion);
	}

}
