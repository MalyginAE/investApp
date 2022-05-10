package com.andrey.malygin.investservice.telegramApi.util;

public enum TelegramMessagesToUser {
    aboutMeMessage("Привет, дорогой подписчик мой подписчик. Приветсвую тебя из будущего, из того самого будущего где мы уже захватили вашу планету, " +
            "где мы знаем движение всех котировок, где люди больше не дерутся за воду. \n" +
            "Чтобы написать меня автору потребовалось три года провести в Тибете, обсудить все свои торговые стратегии с провидецами племени Майя\n" +
            "Так и родился я, широко известный в узких кругах - AndreyInvest. \n" +
            "Данный бот использует торговые стратегии для торговли которые являются собственностью ©Andrey.org Все права не защищещны, но часть прав точно защищена, хотя бы конституцией :) \n" +
            "Иногда от меня будут приходить сигналы на покупку, на являющиеся индивидуальной инвестиционной рекомендацией :) , по активно работующей развиваюшейся стратегии. Всех(почти) обнял. " ),




    messageRecommendedPurchase() , messageRecommendedClose();

    String message;

    public String getMessage() {
        return message;
    }

    TelegramMessagesToUser(String message) {
        this.message = message;
    }

    TelegramMessagesToUser() {
    }
}
