package com.countrydelight.mail;


import com.countrydelight.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class EmailServiceApplication {

   @Autowired
   private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() throws MessagingException {


		emailService.sendEmail(new String[]{},new String[]{},new String[]{},"Email Service Verification","hi All, How Are you doing?",false,false,"path to file ");
	}

}
