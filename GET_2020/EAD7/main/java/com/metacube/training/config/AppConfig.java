package com.metacube.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.shape.MockMailSender;
import com.metacube.training.shape.SMTPMailSender;


@Configuration
public class AppConfig {

	@Bean
	
	public SMTPMailSender helloworld() {
		return new SMTPMailSender();
	}
	
	@Bean
	public MockMailSender naveenJain() {
		return new MockMailSender();
	}
	
	
}
