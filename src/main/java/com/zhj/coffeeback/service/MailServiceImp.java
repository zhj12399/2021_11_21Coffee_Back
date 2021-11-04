package com.zhj.coffeeback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailServiceImp implements MailService
{
    @Autowired
    JavaMailSender mailSender;

    public void SendTextMail(String to, String subject, String content)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.print(to+subject+content);
        message.setSubject(subject);
        message.setFrom("service@zhj12399.cn");
        message.setTo(to);
        message.setSentDate(new Date());
        message.setText(content);
        mailSender.send(message);
    }
}
