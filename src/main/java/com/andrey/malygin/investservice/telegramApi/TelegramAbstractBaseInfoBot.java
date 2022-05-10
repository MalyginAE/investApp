package com.andrey.malygin.investservice.telegramApi;

import com.andrey.malygin.investservice.postgresql.telegram.entities.Chats;
import com.andrey.malygin.investservice.postgresql.telegram.entities.MessageFromUser;
import com.andrey.malygin.investservice.postgresql.telegram.entities.User;
import com.andrey.malygin.investservice.postgresql.telegram.repository.ChatRepository;
import com.andrey.malygin.investservice.postgresql.telegram.repository.MessageRepository;
import com.andrey.malygin.investservice.postgresql.telegram.repository.UserRepository;
import com.andrey.malygin.investservice.telegramApi.util.InputMessageCommands;
import com.andrey.malygin.investservice.telegramApi.util.TelegramBotUtil;
import com.andrey.malygin.investservice.telegramApi.util.TelegramMessagesToUser;
import com.andrey.malygin.investservice.tinkoffApi.InvestApiGettingPersonalDataFromMarketUtil;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tinkoff.piapi.core.models.Money;
import ru.tinkoff.piapi.core.models.SecurityPosition;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public abstract class TelegramAbstractBaseInfoBot {
    static TelegramBot bot = new TelegramBot(TelegramBotUtil.TELEGRAM_TOKEN);

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ChatRepository chatRepository;
    @Autowired
    protected MessageRepository messageRepository;
    @Autowired
    InvestApiGettingPersonalDataFromMarketUtil dataFromMarketUtil;


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
            //отправить приветственное письмо
            //sendMessage(update.message().chat().id(), TelegramMessagesToUser.START_INSTRUCTION.getMessage());
        }

    }

    protected void writeMessageToDataBaseIfExists(Update update) {
        String inputTextFromUser = update.message().text();
        if (!update.message().text().isEmpty()) {
            User user = userRepository.findByUserName(update.message().chat().username())
                    .orElse(userRepository.findByFirstName(update.message().chat().firstName())
                            .orElse(userRepository.findByLastName(update.message().chat().lastName()).orElseThrow())); // гарантируется что не может быть null , потому что перед этим мы заполнили бд данными этого User'a
            //log.info("User = "+user.toString());
            MessageFromUser message = new MessageFromUser(inputTextFromUser, new Date(), user);
            messageRepository.save(message);
        }
    }

    protected void analyzeInputMessage(Message message) {
        String inputText = message.text();
        boolean flag = true;
        for (InputMessageCommands value : InputMessageCommands.values()) {
            if (inputText.contains(value.getCommand())) {
                sendAnswer(message, value);
                flag = false;
            }
        }
        if (flag) sendMessage(message.chat().id(), TelegramMessagesToUser.START_INSTRUCTION.getMessage());

    }

    private void sendAnswer(Message message, InputMessageCommands value) {
        long chatId = message.chat().id();
        switch (value) {
            case START -> {
                sendMessage(chatId, TelegramMessagesToUser.START_INSTRUCTION.getMessage());
                sendMessage(chatId, TelegramMessagesToUser.aboutMeMessage.getMessage());
            }
            case DESCRIPTION -> sendMessage(chatId, TelegramMessagesToUser.aboutMeMessage.getMessage());
            case MESSSAGETOANDREY -> sendMessageToAndrey(message);
            case CURRENTBALANCE -> sendMessage(chatId, getBalanceText(TelegramMessagesToUser.currentBalance.getMessage()));
            default -> sendMessage(message.chat().id(), TelegramMessagesToUser.START_INSTRUCTION.getMessage());
        }

    }

    private String getBalanceText(String startText) {
        StringBuilder builder = new StringBuilder(startText);
        List<Money> monies = dataFromMarketUtil.getListMoney();
        for (Money money : monies) {
            builder.append(money.getCurrency().getCurrencyCode() + " : " + money.getValue() + "\n");
        }
        List<SecurityPosition> activePosition = dataFromMarketUtil.getMyActivePosition();
        for (SecurityPosition securityPosition : activePosition) {
            builder.append(TelegramBotUtil.FigiStockMap.get(securityPosition.getFigi()) + " : " + securityPosition.getBalance());
        }
        return String.valueOf(builder);
    }

    private void sendMessageToAndrey(Message message) {
        Optional<User> user = userRepository.findByUserName("androidmalygin");
        String messageToAndrey = String.format("Мой господин, вам пришло письмо от %s: %s %s. Текст сообщения: \"%s\" ", message.chat().username(),
                message.chat().firstName(), message.chat().lastName(), message.text());

        SendMessage sendMessage = new SendMessage(user.orElseThrow().getChat_id().getChatId(), messageToAndrey);
        bot.execute(sendMessage);
    }


    protected void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        bot.execute(sendMessage);
    }


}
