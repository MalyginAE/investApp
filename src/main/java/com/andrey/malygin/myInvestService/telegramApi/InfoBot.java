package com.andrey.malygin.myInvestService.telegramApi;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
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
                    .forEach(System.out::println);
            sendMessageEveryone("привет, дорогой друг");
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }


}
