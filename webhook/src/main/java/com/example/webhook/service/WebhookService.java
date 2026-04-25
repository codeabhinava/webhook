package com.example.webhook.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebhookService {

    private static final Logger logger = LoggerFactory.getLogger(WebhookService.class);

    private static final Map<String, String> REPLIES = Map.of(
            "hi", "Hello! 👋 How can I help you?",
            "hello", "Hey there! 😊",
            "bye", "Goodbye! 👋",
            "help", "You can say: Hi, Hello, Bye, or Help."
    );

    public String getReply(String message) {
        if (message == null || message.isBlank()) {
            return "Please send a non-empty message.";
        }
        String key = message.trim().toLowerCase();
        String reply = REPLIES.getOrDefault(key, "Sorry, I didn't understand that.");
        logger.info("Message: \"{}\" → Reply: \"{}\"", message, reply);
        return reply;
    }
}
