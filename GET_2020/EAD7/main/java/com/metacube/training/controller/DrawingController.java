package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.shape.MailSender;
import com.metacube.training.shape.SMTPMailSender;

@RestController
public class DrawingController {
	private MailSender mail;
	
	
	@Autowired
	@Qualifier("SMTPMailSender")
	public void setMail(MailSender helloworld) {
		this.mail = helloworld;
	}
	

//	@Autowired
//	public DrawingController( MailSender b) {
//		this.mail = b;
//	}
	
	

	@GetMapping("/draw") 
	public String test() {
		
		mail.sendMail();
		
		return "mail sent";
	}
	
}
