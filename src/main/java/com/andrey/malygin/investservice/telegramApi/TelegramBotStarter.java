package com.andrey.malygin.investservice.telegramApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotStarter {
    @Autowired
    InfoBot infoBot;

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        infoBot.serve();
    }
}

