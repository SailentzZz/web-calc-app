package Classes;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.log4j.Logger;

public class SSLEmail {
	private String fromEmail; //requires valid gmail id
	private String password; // correct password for gmail id
	private String toEmail; // can be any email id
	private String body;
	private int key;
	
	Logger logger = Logger.getLogger(SSLEmail.class);
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 465
	 */
	
	public void setPas(String pas) {
		password = pas;
	}
	
	public void setFile(String pas) {
		body = pas;
	}
	
	public void setFromEmail(String pas) {
		fromEmail = pas;
	}
	
	public void setToEmail(String pas) {
		toEmail = pas;
	}
	
	public void setKey(int pas) {
		key = pas;
	}
	
	public int getKey() {
		return key;
	}
	
	public void send() {
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "587"); //SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "587"); //SMTP Port
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("proverkaemailsend@gmail.com", "svd111000");
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		logger.info("Session created");
		EmailUtil.sendEmail(session, toEmail, "proverkaemailsend@gmail.com", "Thank you for registration!");

	}
	
	public void sendProps(String toEmail) {
		try {
			System.out.println("SSLEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
			props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
			props.put("mail.smtp.port", "465"); //SMTP Port
			
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("proverkaemailsend@gmail.com", "trawin1999");
				}
			};
			
			Session session = Session.getDefaultInstance(props, auth);
			logger.info("Session created");
		    EmailUtil.sendEmail(session, toEmail,"Security", "Thank you for registration");
		    
	    } catch (Exception e) {
	      e.printStackTrace();
	      logger.error(e);
	    }
	}


	public void sendOrder(String toEmail, String Login, String Password) {
		try {
			System.out.println("SSLEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
			props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
			props.put("mail.smtp.port", "465"); //SMTP Port
			
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("proverkaemailsend@gmail.com", "trawin1999");
				}
			};
			
			Random rnd = new Random(System.currentTimeMillis());
			key = 100 + rnd.nextInt(1000 - 100 + 1);
			
			Session session = Session.getDefaultInstance(props, auth);
			logger.info("Session created");
		        EmailUtil.sendEmail(session, toEmail,"Accaunt manager", "Login : " + Login + "\n" + "Password: " + Password + "\n");
		        
	    } catch (Exception e) {
	      e.printStackTrace();
	      logger.error(e);
	    }
	}


}