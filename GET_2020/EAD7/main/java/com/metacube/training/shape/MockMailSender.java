package com.metacube.training.shape;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MockMailSender implements MailSender{


	@Override
	public void sendMail() {
		// TODO Auto-generated method stub
		System.out.println("Mail Sent by mockmail");
	}

}
