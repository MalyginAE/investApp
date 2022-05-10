package com.andrey.malygin.investservice.telegramApi;

import com.pengrad.telegrambot.UpdatesListener;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class InfoBot extends TelegramAbstractBaseInfoBot {
    // Подписка на обновления
    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.stream()
                    .peek(this::checkAndSaveData)
                    .peek(this::writeMessageToDataBaseIfExists)
                    .peek(it -> analyzeInputMessage(it.message()))
                    .forEach(System.out::println);
            sendMessageEveryone("привет, дорогой друг");
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }


}
