package tn.sarra.easily_stock.tasklet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;

import tn.sarra.easily_stock.business.EmailService;
import tn.sarra.easily_stock.business.EntrepotServices;


public class SendEmailTasklet implements Tasklet{
	
	@Autowired
    private EmailService emailService;
	
	@Autowired
	 private EntrepotServices entrepotServices;
	
	 private static final Logger LOG = LoggerFactory.getLogger(SendEmailTasklet.class);
	 private StringBuilder sb = new StringBuilder();
	 
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception, IOException, AddressException, MessagingException {
		System.out.println("Sending email..");
		sb.append("Bonjour");
		sb.append("\n \n");
		sb.append("Les entrepots dont la capacité restante est 20% de leur capacité globale pour le : ");
		sb.append(LocalDate.now());
		sb.append(" ");
		sb.append("sont :");
		sb.append(entrepotServices.getEntrepotsWithCapacityAlert().stream().map(n -> String.valueOf(n))
			      .collect(Collectors.joining(",", "\n", "\n")));
		
		 
		 try {
	            emailService.sendEmail("shewearwebsite1993@gmail.com", "Alerte!! Capacité des entrepôts", sb.toString());
	        } catch (MailException mailException) {
	            LOG.error("Error while sending out email..{}", mailException.getStackTrace());
	            
	        }
         
        System.out.println("Sending email done..");
        return RepeatStatus.FINISHED;
	}

}
