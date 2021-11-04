package com.zhj.coffeeback.service;

public interface MailService
{
    void SendTextMail(String to, String subject, String content);
}
