package tn.sarra.easily_stock.business;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {
	void sendEmail(String toAddress, String subject, String message) throws IOException, AddressException, MessagingException;
}

