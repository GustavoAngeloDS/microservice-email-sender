package com.ms.email.services;

import com.ms.email.models.EmailModel;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Service
public class EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Value("${mail.from}")
    private String emailFrom;

    private JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void buildAndSendEmail(EmailModel emailModel) {
        MimeMessage emailMessage = buildEmailMessage(emailModel);
        sendEmail(emailMessage);
    }

    @SneakyThrows
    public MimeMessage buildEmailMessage(EmailModel emailModel) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, false, "utf-8");

        message.setContent(emailModel.getText(), "text/html");
        helper.setTo(emailModel.getEmailTo());
        helper.setSubject(emailModel.getSubject());
        helper.setFrom(emailFrom);

        return message;
    }

    private void sendEmail(MimeMessage message) {
        LOGGER.debug("SENDING MAIL ["+LocalDateTime.now()+"]");
        try{
            emailSender.send(message);
            LOGGER.debug("SENT SUCCESSFULLY ["+LocalDateTime.now()+"]");
        } catch (MailException e) {
            LOGGER.error("ERROR: " + e.getMessage());
        }
    }
}
