package com.marketingapp9.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
 

@Component
public class EmailServiceimpl implements EmailService {

	private JavaMailSender sender;
	
	@Override
	public void sendEmail(String to, String sub, String message) {
        SimpleMailMessage content = new SimpleMailMessage();
        content.setTo(to);
        content.setSubject(sub);
        content.setText(message);
        sender.send(content);
        
		
	}

}
