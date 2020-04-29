package com.bridgelabz.redisexample.resource;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.redisexample.model.User;
import com.bridgelabz.redisexample.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
private UserRepository userRepository;

public UserResource(UserRepository userRepository) {
	this.userRepository=userRepository;
}
//adding some get rest end points
@GetMapping("/add/{id}/{name}")
public User add(@PathVariable("id") final String id,
		  @PathVariable("name") final String name) {
	userRepository.save(new User(id, name, 20000l));
	 return userRepository.findById(id);
}

@GetMapping("/update/{id}/{name}")
public User update(@PathVariable("id") final String id,
		  @PathVariable("name") final String name) {
	userRepository.update(new User(id, name, 10000l));
	 return userRepository.findById(id);
}

@GetMapping("/all")
public Map<String, User> update(){
	
return userRepository.findAll();
}

}
