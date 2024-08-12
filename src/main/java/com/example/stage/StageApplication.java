package com.example.stage;

import com.example.stage.ServiceImpl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class StageApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(StageApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void sendMail(){
        senderService.sendSimpleEmail("ghedirnaima3@gmail.com",
                "this is subject" ,
                "this is body of email");
    }
}
