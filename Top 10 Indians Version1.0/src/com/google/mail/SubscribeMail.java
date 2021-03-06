package com.google.mail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SubscribeMail {
		public static void sendMail(String email)
	    {    
			String msg="Thanks for Giving Your Comments";
			System.out.println(email);
	       // Recipient's email ID needs to be mentioned.
	       //String to = "@gmail.com";

	       // Sender's email ID needs to be mentioned
	       String from = "xxxxxxxxxxxx@gmail.com";

	       
	       // Get system properties
	       Properties props = new Properties();
	         props.put("mail.smtp.starttls.enable", "true");
	         props.put("mail.smtp.auth", "true");
	         props.put("mail.smtp.host", "smtp.gmail.com");
	         props.put("mail.smtp.port", "587");
	       

	       // Get the default Session object.
	          
	       //Session session = Session.getDefaultInstance(props);

	         Session session = Session.getInstance(props,
	              new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication("xxxxxxxxxxxxx@gmail.com","xxxxxxx");
	                }
	              });
	          
	       try{
	          /* Create a default MimeMessage object.
	           * one for admin 
	           * another for user
	           * */
	          MimeMessage message1 = new MimeMessage(session);
	           MimeMessage message2=new MimeMessage(session);
	           
	          /* it take from address  of  admin
	           * 
	           * */
	          message1.setFrom(new InternetAddress(from));

	          /* 
	           * this for  to whom to send msg */
	          message1.addRecipient(Message.RecipientType.TO, new InternetAddress(from));
	          message2.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	          //System.out.println("mail is sending to who are gining comments"+email);
	          
	          /*it will set subject*/
	          message1.setSubject("Scbscribe");

	          /* it will display commenter name and email and comment*/
	          message1.setText("Email:"+email);
	          
	          /*this  mail send to admin*/
	          Transport.send(message1);
	          System.out.println("Sent message successfully....");
	          
	          /*replying for comments
	           * set  subject for  replying
	           * */
	          message2.setSubject("Reply From Top 10 Indian's");
	          message2.setText("\n\n"+"Hi,  "+email+"\n Thanks for Subscribing  ");
	          //System.out.println("\n\n"+"Hai, "+name+" Thanks for Giving Your Comments "+" email is "+email+" meassage "+message);
	          Transport.send(message2);
	          System.out.println("Sent message successfully....");
	       }catch (MessagingException mex) {
	          mex.printStackTrace();
	       }
	    }
	}