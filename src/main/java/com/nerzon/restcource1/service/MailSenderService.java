package com.nerzon.restcource1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //чтобы не создавать конструктор для автовайреда
public class MailSenderService {
    private final JavaMailSender mailSender; //необходимо автовайрить интерфейс для работы почты

    @Value("${spring.mail.username}") //обращаемся к указанной почте в пропертях
    private String from;


    public void sendMail(String to, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage(); //для создания письма
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        message.setFrom(from);

        mailSender.send(message); //для отправки письма

    }

}
