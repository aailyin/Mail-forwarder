package com.exadel.mailforwarder.service.interfaces;


public interface MailService {

    public void sendMail(String from, String to, String subject, String body);

}