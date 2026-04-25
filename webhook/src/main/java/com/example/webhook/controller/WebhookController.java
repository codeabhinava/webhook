package com.example.webhook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webhook.model.Reciever;
import com.example.webhook.model.Sender;
import com.example.webhook.service.WebhookService;

@RestController
@RequestMapping("/web")
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/webhook")
    public Reciever handleWebhook(@RequestBody Sender incoming) {
        logger.info("Incoming message: {}", incoming);
        String reply = webhookService.getReply(incoming.getMessage());
        logger.info("Replying with: {}", reply);
        return new Reciever(incoming.getFrom(), incoming.getMessage(), reply);
    }
}
