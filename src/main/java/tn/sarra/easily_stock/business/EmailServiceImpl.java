package tn.sarra.easily_stock.business;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService{


	 @Autowired
	 public JavaMailSender emailSender;

	  
	@Override
	public void sendEmail(String toAddress, String subject, String message)  throws IOException, AddressException, MessagingException {
		  
		  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		  simpleMailMessage.setTo(toAddress);
		  simpleMailMessage.setSubject(subject);
		  simpleMailMessage.setText(message);
		  emailSender.send(simpleMailMessage);
		}
	
}
