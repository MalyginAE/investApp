package com.andrey.malygin.myInvestService.telegramApi;

//import com.andrey.malygin.myInvestService.postgresql.telegram.entities.Chats;
import com.andrey.malygin.myInvestService.postgresql.telegram.entities.User;
import com.andrey.malygin.myInvestService.postgresql.telegram.repository.UserRepository;
import com.andrey.malygin.myInvestService.telegramApi.util.TelegramBotUtil;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@NoArgsConstructor
@AllArgsConstructor

public class InfoBot {
    // Создание бота путем передачи токена, полученного от @BotFather
    static TelegramBot bot = new TelegramBot(TelegramBotUtil.TELEGRAM_TOKEN);

    @Autowired
    private  UserRepository repository;



    // Подписка на обновления
    public void serve() {
        bot.setUpdatesListener(updates -> {
            System.out.println("пришло событие");
            User user = new User(updates.get(0).updateId().toString(),"dsaf","dfsfsdf");
            repository.save(user);
            long b = repository.count();
            System.out.println(b);
            long chatId = updates.get(0).message().chat().id();
            SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
            //TODO реализовать запоминание chatId в бд


            sendMessageAll(chatId,"hello");
            // ... process updates
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    public void sendMessageAll(long id,String hello) {
        bot.execute(new SendMessage(id,"принеси подай"));
    }


}
