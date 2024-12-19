package com.example.a2f_a;

import android.util.Log;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {
    public static void sendEmail(String recipient, String subject, String body) {
        new Thread(() -> {
            try {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");

                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("besarta.mustafa4@student.uni-pr.edu", "hnes nzho xgmc pjqy");
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("besarta.mustafa4@student.uni-pr.edu"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                message.setSubject(subject);
                message.setText(body);

                Transport.send(message);
            } catch (MessagingException e) {
                Log.e("EmailService", "Error sending email", e);
                e.printStackTrace();
            }
        }).start();
    }
}

