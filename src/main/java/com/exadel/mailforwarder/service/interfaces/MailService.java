package com.exadel.mailforwarder.service.interfaces;

/**
 * Simple interface for to send e-mails.
 *
 * @author aa.ilyin
*/
public interface MailService {

    public void sendMail(String from, String to, String subject, String body);

}