package com.example.demo.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user/login")
	public String login(@RequestParam(value="username") String username ,
			@RequestParam(value="password") String password,
			HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("用户进行了登录操作！");
		
		User user = userService.findByName(username);
		if (! StringUtils.isEmpty(user)) {
			if (user.getPassword().equals(password)) {
				session.setAttribute("loginsuccess",user.getUsername());
				return "redirect:/success";
			}else {
				request.setAttribute("msg","登录失败");
				return "login";
			//	request.getRequestDispatcher("/login").forward(request, response);
			}
		}
		return "login";
	}
}
