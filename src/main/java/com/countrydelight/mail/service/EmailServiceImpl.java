package com.countrydelight.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@Service
public class EmailServiceImpl implements EmailService{


    //Sender email address
    private final String NOREPLY_ADDRESS="xyz@gmail.com";

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String[] to,String[] cc,String[] bcc,String subject, String text, Boolean htmlText, Boolean isAttachment, String pathToAttachment) {
            try {
                MimeMessage message = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                helper.setFrom(NOREPLY_ADDRESS);
                helper.setTo(to);
                if(cc.length != 0)
                    helper.setCc(cc);
                if(bcc.length != 0)
                      helper.setBcc(bcc);
                helper.setSubject(subject);
                if(isAttachment && htmlText)
                {
                    helper.setText(text, true);
                    FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
                    helper.addAttachment("IncrementLetter.pdf", file);
                }
                else if(htmlText)
                    helper.setText(text, true);
                else
                    helper.setText(text,false);

                emailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
}
