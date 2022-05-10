package com.andrey.malygin.investservice.telegramApi;

import com.pengrad.telegrambot.UpdatesListener;

import static com.andrey.malygin.investservice.telegramApi.TelegramAbstractBaseInfoBot.bot;

public class InfoBotAdmin extends TelegramAdminManageAbstractBot {
    // Подписка на обновления
    public void serve() {
        bot.setUpdatesListener(updates -> {
//            updates.stream()
//                    .filter(x -> x.message() != null)
//                    .peek(this::checkAndSaveData)
//                    .peek(this::writeMessageToDataBaseIfExists)
//                    .peek(it -> analyzeInputMessage(it.message()))
//                    .forEach(System.out::println);

            // sendMessageEveryone("привет, дорогой друг");
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
