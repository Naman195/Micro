package com.ics.security.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics.security.dto.LoginReq;
import com.ics.security.dto.UserDTO;
import com.ics.security.entity.User;
import com.ics.security.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private  UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User createUser(UserDTO dto) throws Exception {
		String email = dto.getEmail();
		Optional<User> userr = userRepository.findByEmail(email);
		if(userr.isPresent()) {
			
			throw new Exception(String.format("User with the email address '%s' already exists.", email));
		}
		User user = modelMapper.map(dto, User.class);
		return userRepository.save(user);
	}
	
	public User login(LoginReq req) throws Exception {
		
		Optional<User> user = userRepository.findByEmail(req.getEmail());
		if(user.isPresent()) {
			String pass = req.getPassword();
			if(pass.equals(user.get().getPassword())) {
				return user.get();
			}
		}
		throw new Exception(String.format("User with the email address '%s' Not exist exists.", req.getEmail()));
	}
	
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
