package com.example.webhook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Reciever {

    private String from;

    private String message;

    private String reply;

    public Reciever(String from, String message, String reply) {
        this.from = from;
        this.message = message;
        this.reply = reply;

    }

}
