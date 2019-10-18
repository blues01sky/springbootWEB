package com.example.demo.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public Integer deleteById(int id) {
		// TODO Auto-generated method stub
		return userRepository.deleteById(id);
	}

	@Override
	public Integer deleteByName(String username) {
		// TODO Auto-generated method stub
		return userRepository.deleteByName(username);
	}

	@Override
	public Integer updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.updatePassword(username,password);
	}

	@Override
	public Integer updateUser(int id, String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.updateUser(id, username, password);
	}

	@Override
	public Integer addUser(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.addUser(username,password);
	}
	
}
