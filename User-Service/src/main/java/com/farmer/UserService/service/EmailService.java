package com.farmer.UserService.service;


import com.farmer.UserService.model.EmailDetails;

public interface EmailService {


    <EmailDetails> String sendSimpleMail(EmailDetails details);

    String sendSimpleMail(EmailDetails details);


    String sendMailWithAttachment(EmailDetails details);
}
