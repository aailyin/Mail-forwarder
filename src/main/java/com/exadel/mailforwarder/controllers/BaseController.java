package com.exadel.mailforwarder.controllers;

import com.exadel.mailforwarder.service.interfaces.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Base controller for application. Handles requests for URI '/MailForwarder'
 *
 * @author aa.ilyin
 */
@Controller
@RequestMapping("/MailForwarder")
public class BaseController {

    @Autowired
    private MailService mailService;

    @Autowired
    private SimpleMailMessage mailMessage;

    public BaseController(){}


    /**
     * Method handles the requests for URI '/index'. Returns the string
     * "E-mail was sent" if it works correctly.
     *
     * @param modelMap - map for page
    */
    @RequestMapping("/index")
    public String sendMail(ModelMap modelMap){
        StringBuilder builder = new StringBuilder();
        for(String s : mailMessage.getTo()) {
            builder.append(s);
        }
        mailService.sendMail(mailMessage.getFrom(),
                             builder.toString(),
                             mailMessage.getSubject(),
                             mailMessage.getText());
        modelMap.addAttribute("message", "E-mail was sent");
        return "index";
    }

}