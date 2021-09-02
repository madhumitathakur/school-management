package pu.mca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pu.mca.models.ClassDetails;
import pu.mca.models.Result;
import pu.mca.models.User;
import pu.mca.service.UserService;

@RestController
@CrossOrigin
public class SchoolController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		return userService.getUsers();	
	}
	
	@GetMapping("/users/{id}")
	public User getStudent(@PathVariable("id") Long id) {
		
		return userService.getUserById(id);	
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user ) {
		
		return userService.login(user);
	}
	
	@PostMapping("/signup")
	public User signup(@RequestBody User user ) {
		
		return userService.signup(user);
	}
	
	@GetMapping("/classes")
	public List<ClassDetails> getAllClasses() {
		
		return userService.getAllClasses();	
	}
	
	@GetMapping("/results/{userId}/{classId}")
	public List<Result> getResult(@PathVariable("userId") Long userId, @PathVariable("classId") Long classId) {
		
		return userService.getResult(userId, classId);	
	}
	
	@GetMapping("/admission/{userId}/{classId}")
	public User getAdmission(@PathVariable("userId") Long userId, @PathVariable("classId") Long classId) {
		
		return userService.getAdmission(userId, classId);	
	}
	
	@PutMapping("/fee")
	public ClassDetails updateFee1(@RequestBody ClassDetails fee) {
		
		return userService.updateFee(fee);	
	}

}
