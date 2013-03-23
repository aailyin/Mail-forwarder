package com.exadel.mailforwarder.controllers;

import com.exadel.mailforwarder.service.interfaces.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
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