package com.social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("socialmiddleware,com.social")
public class WebResolver 
{
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/jsp");
		resolver.setPrefix(".jsp");
		
		System.out.println("==Internal Resource View Resolver:");
		return resolver;
	}
}