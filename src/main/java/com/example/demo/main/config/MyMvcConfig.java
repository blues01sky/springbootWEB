package com.example.demo.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*@EnableWebMvc
 * 
 * 
 * SpringBoot对SpringMVC的自动配置不需要了，所有都是我们自己配置；所有的SpringMVC的自动配置都失效了
 * 
 * 
*/
@SuppressWarnings("deprecation")
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		System.out.println("重写了addViewControllers方法");
		// TODO Auto-generated method stub
		registry.addViewController("hi").setViewName("index");
	}*/

	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("404");
				registry.addViewController("/index.html").setViewName("index");
				registry.addViewController("/index").setViewName("index");
				registry.addViewController("/login").setViewName("index");
				registry.addViewController("/success").setViewName("success");
				System.out.println("视图控制器起作用了");
			}
			
			/*@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/login","/user/login");
			}*/
		};
		
		
		return adapter;
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		System.out.println("国际化语言的配置也 ok");
		return new myLanguage();
	}

}
