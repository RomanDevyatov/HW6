package com.netcracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Controller
public class EmailController {

    @GetMapping("/persons/email")
    public String displayEmailPersonForm(Model model){
        model.addAttribute("title", "Email");
        return "/persons/email";
    }

    @PostMapping("/persons/email")
    public String processEmailPersonForm(@RequestParam String emailFrom,
                                         @RequestParam String emailPassword,
                                         @RequestParam String emailTo,
                                         @RequestParam String textMessage
                                         ){
        try {
            String pass=emailPassword;

            java.util.Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.mail.ru");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");

            props.put("mail.smtp.connectiontimeout", "60000");
            props.put("mail.smtp.timeout", "60000");
            props.put("mail.debug", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(emailFrom, pass));
                }
            });
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(emailFrom);
            msg.setFrom(addressFrom);
            InternetAddress addressTo = new InternetAddress(emailTo);
            msg.setRecipient(Message.RecipientType.TO, addressTo);
            msg.setSubject("testemail");
            msg.setText(textMessage);
            Transport.send(msg);
        } catch (Throwable e) {
            System.err.println("Exception : " + e.toString());
        }
        return "redirect:";
    }

}
