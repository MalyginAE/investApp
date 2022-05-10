package com.andrey.malygin.myInvestService.telegramApi;

import com.andrey.malygin.myInvestService.postgresql.telegram.entities.Chats;
import com.andrey.malygin.myInvestService.postgresql.telegram.entities.MessageFromUser;
import com.andrey.malygin.myInvestService.postgresql.telegram.entities.User;
import com.andrey.malygin.myInvestService.postgresql.telegram.repository.ChatRepository;
import com.andrey.malygin.myInvestService.postgresql.telegram.repository.MessageRepository;
import com.andrey.malygin.myInvestService.postgresql.telegram.repository.UserRepository;
import com.andrey.malygin.myInvestService.telegramApi.util.TelegramBotUtil;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Objects;

@Slf4j
public abstract class TelegramAbstractBaseInfoBot {
    static TelegramBot bot = new TelegramBot(TelegramBotUtil.TELEGRAM_TOKEN);

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ChatRepository chatRepository;
    @Autowired
    protected MessageRepository messageRepository;


    protected void sendMessageEveryone(String message) {
        Iterable<Chats> allChats = chatRepository.findAll();
        for (Chats chats : allChats) {
            SendMessage sendMessage = new SendMessage(chats.getChatId(), message);
            bot.execute(sendMessage);
        }
    }


    protected void checkAndSaveData(Update update) {
        log.info("checkAndSaveData invoked");
        Chats chat = chatRepository.findByChatId(update.message().chat().id()).orElse(null);
        if (Objects.isNull(chat)) {
            chat = new Chats(update.message().chat().id());
            chatRepository.save(chat);
        }
        if (userRepository.findByUserName(update.message().chat().username()).isEmpty()) {
            User user = new User(update.message().chat().username(), update.message().chat().firstName(),
                    update.message().chat().lastName(), chat);
            userRepository.save(user);
        }

    }


    protected void writeMessageToDataBaseIfExists(Update update){
        String inputTextFromUser = update.message().text();
        if (!update.message().text().isEmpty()) {
            User user = userRepository.findByUserName(update.message().chat().username()).orElseThrow(); // гарантируется что не может быть null , потому что перед этим мы заполнили бд данными этого User'a
            MessageFromUser message = new MessageFromUser(inputTextFromUser, new Date(),user);
            messageRepository.save(message);

        }
    }


}
