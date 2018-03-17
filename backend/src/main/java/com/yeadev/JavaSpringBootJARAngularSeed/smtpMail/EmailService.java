package com.yeadev.JavaSpringBootJARAngularSeed.smtpMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

// a service that take an email object and sent it out
// ref: https://www.quickprogrammingtips.com/spring-boot/how-to-send-email-from-spring-boot-applications.html
@Service
public class EmailService {

    private JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(Email email) throws Exception {

        MimeMessage message = sender.createMimeMessage();

        // Enable the multipart flag!
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email.getTo());
        helper.setCc(email.getCc());
        helper.setText(email.getMessage(), email.isHtml());
        helper.setSubject(email.getSubject());

        sender.send(message);
    }
}
