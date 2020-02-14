package com.metacube.training.shape;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
@Component
public class SMTPMailSender implements MailSender {

	@Override
	public void sendMail() {
		// TODO Auto-generated method stub
		System.out.println("Mail Sent by smtp");
	}
}
