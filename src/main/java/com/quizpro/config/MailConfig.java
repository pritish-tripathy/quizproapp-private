package com.quizpro.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	//move to application.properties this bean,, keep this class as empty.
	@Bean
	public JavaMailSender javaMailSenderImpl() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(465);
		mailSender.setUsername("g.umamahesh2@gmail.com");
		mailSender.setPassword("eicl mckw tpax mjxt");
		
		Properties prop = mailSender.getJavaMailProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.startssl.enable", "true");
		// prop.put("mail.debug", "true");
		return mailSender;
	}
}
