package com.example.webhook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Sender {

    private String from;
    private String to;
    private String message;

    public Sender(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;

    }

}
