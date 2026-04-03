package com.xworkz.fileupload.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpSender {

    @Autowired
    JavaMailSender javaMailSender;

    private String generatedOtp;

    public String generateOtp() {
        generatedOtp = String.valueOf(100000 + new Random().nextInt(900000));
        return generatedOtp;
    }

    public void sendSimpleMessage(String to, String subject, String text) {

        String otp = generateOtp();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sn389854@gmail.com");
        message.setTo(to);
        message.setSubject("OTP");
        message.setText(otp);

        javaMailSender.send(message);
    }

    public String getGeneratedOtp() {
        return generatedOtp;
    }
}