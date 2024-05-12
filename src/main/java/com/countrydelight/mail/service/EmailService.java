package com.countrydelight.mail.service;



public interface EmailService {

     void sendEmail(String[] to,String[] cc,String[] bcc,String subject,String text,Boolean htmlText, Boolean isAttachment, String pathToAttachment);

}
