package com.mdev.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private MessageSource messageSource;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
		// registry.addViewController("/home").setViewName("userhome");
		registry.addViewController("/admin/home").setViewName("adminhome");
		// registry.addViewController("/403").setViewName("403");
	}

//	@Override
//	public Validator getValidator() {
//		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//		factory.setValidationMessageSource(messageSource);
//		return factory;
//	}

	@Bean
	public SpringSecurityDialect securityDialect() {
		return new SpringSecurityDialect();
	}

}
