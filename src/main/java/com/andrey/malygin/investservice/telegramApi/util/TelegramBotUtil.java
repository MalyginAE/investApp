package com.andrey.malygin.investservice.telegramApi.util;

import java.util.Map;

public class TelegramBotUtil {
    public final static String TELEGRAM_TOKEN = System.getProperty("telegram_token");
    public static final Map<String,String> FigiStockMap = Map.of("BBG004S68758" ,"Башнефть",
            "BBG004730JJ5" ,"Московская Биржа",
            "BBG004S686N0" ,"Башнефть — привилегированные акции",
            "BBG008F2T3T2" ,"РУСАЛ",
            "BBG004731489", "Норильский никель",
            "BBG000Q7GG57" ,"ТГК-2",
            "BBG005D1WCQ1" ,"QIWI",
            "BBG004S686W0" ,"Юнипро",
            "BBG004S68FR6" ,"Мечел — Привилегированные акции",
            "BBG006L8G4H1" ,"Yandex");
}
