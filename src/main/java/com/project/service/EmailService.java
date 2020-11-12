package com.project.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService{

	public static void sendMail(String recepient, String subject, String message)
	{
		System.out.println("preparing to send email");
		Properties prop = new Properties();
		
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		String senderEmail = "mochicircleguy@gmail.com";
		String pas = "circlemochi";
		
		Session ses = Session.getInstance(prop,new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail,pas);
			}
		});
		
		Message msg = prepareMessage(ses, senderEmail,recepient,subject,message);
		
		try {
			Transport.send(msg);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private	static Message prepareMessage(Session ses, String email,
			String recepient, String sub, String msg)
	{
		Message message = new MimeMessage(ses);
		
		try {
			message.setFrom(new InternetAddress(email));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject(sub);
			message.setContent(msg,"text/html");
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
