package tn.sarra.easily_stock.api;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.sarra.easily_stock.business.EmailService;


@RestController
@RequestMapping("/email")
public class EmailRestController {
	
	 
	
	 private static final Logger LOG = LoggerFactory.getLogger(EmailRestController.class);
	 
		@Autowired
	    EmailService emailService;
	    
		  @GetMapping(value = "/simple-email")
		  public @ResponseBody ResponseEntity sendSimpleEmail() throws IOException, AddressException, MessagingException{

		        try {
		            emailService.sendEmail("shewearwebsite1993@gmail.com", "Welcome", "This is a welcome email for you!!");
		        } catch (MailException mailException) {
		            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
		            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		        return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
		    }
}
