package com.example.demo.main.config;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

public class myLanguage implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String string= request.getParameter("l");
		Locale locale = Locale.getDefault();
		if (!StringUtils.isEmpty(string)) {
			String[] strings = string.split("_");
			System.out.println("user set encoding , And"+"Encoding is "+strings[1]);
			locale  = new Locale(strings[0], strings[1]);
		}
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}
	
}
