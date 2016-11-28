package com.ro.learn.businesslogic;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.util.Date;
import java.util.Properties;

/**
 * Created by rohan on 2016-11-27.
 */
@Stateless(name = "EmailSenderEJB")
public class EmailSenderEJB {
    Properties props = new Properties();
    private String username;
    private String password;

    public EmailSenderEJB() {
        username = "mutantstest01@gmail.com";
        password = "mutantstest@123";
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.from", "mutantstest01@gmail.com");
    }

    public void sendEmail() {
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("mutantstest01@gmail.com"));
            InternetAddress[] address = {new InternetAddress("wrohanc@gmail.com")};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject("Test email subject");
            message.setSentDate(new Date());

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Test email body");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            //attachment as byte[]
            /*byte[] attachment = null;

            if(attachment != null) {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new ByteArrayDataSource(attachment, "application/octet-stream");
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName("attachment.txt");
                multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);*/

            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
