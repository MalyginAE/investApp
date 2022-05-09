package com.andrey.malygin.myInvestService.telegramApi;

import com.andrey.malygin.myInvestService.postgresql.telegram.repository.UserRepository;
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
        System.out.println("бот стартанул");
    }
}

