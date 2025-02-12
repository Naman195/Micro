package com.ics.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics.security.dto.LoginReq;
import com.ics.security.dto.UserDTO;
import com.ics.security.entity.User;
import com.ics.security.repository.UserRepository;
import com.ics.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private  UserService userService;
	
	@PostMapping("/create")
	public User craeteUser(@RequestBody UserDTO dto) throws Exception {
		
		return userService.createUser(dto);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginReq req) throws Exception {
		return userService.login(req);
	}
	
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
