package com.exadel.mailforwarder.service.implementation;

import com.exadel.mailforwarder.service.interfaces.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Implementation of interface MailService.
 *
 * @author aa.ilyin
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender mailSender;

    public MailServiceImpl(){}

    /**
     * Method sends the e-mail to the specified address.
     *
     * @param from - what from address to send
     * @param to - whom to send
     * @param subject - subject of message
     * @param body - body of message
    */
    @Override
    public void sendMail(String from, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}