package com.example.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.user.entity.User;

@Service
public interface UserService {
	List<User> findAll();
	
	User findById(int id);
	
	User findByName(String username);
	
	Integer deleteById(int id);
	
	Integer deleteByName(String username);
	
	Integer updatePassword(String username,String password);
	
	Integer updateUser(int id,String username,String password);
	
	Integer addUser(String username,String password);
	
}
