package io.github.bragabriel.springarchitecture.todos;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    public void send(String message){
        System.out.println("Email sent: " + message);
    }
}
