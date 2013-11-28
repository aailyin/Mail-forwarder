package com.exadel.mailforwarder;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * A simple application to send email.
 * */
public class SendMail {

    private final static Integer PORT = 465;
    private final static String HOSTNAME = "smtp.gmail.com";
    private String mailsender;
    private String mailrecipient;

    public SendMail(String mailsender, String mailrecipient){
        this.mailsender = mailsender;
        this.mailrecipient = mailrecipient;
    }

    public static void main(String[] args) {
        SendMail sendMail = new SendMail("antonaleksei.ilyin@gmail.com","antonaleksei.ilyin@gmail.com");

        Properties props = sendMail.createProps(PORT, PORT, HOSTNAME);

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("antonaleksei.ilyin@gmail.com","password");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress());
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("antonaleksei.ilyin@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Test application for to send emails");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    private Properties createProps(Integer socketport, Integer port, String hostname){
        Properties props = new Properties();
        props.put("mail.smtp.host", hostname);
        props.put("mail.smtp.socketFactory.port", socketport);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);

        return props;
    }
}
