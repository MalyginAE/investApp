package com.andrey.malygin.investservice.tinkoffApi.helpers;

import ru.tinkoff.piapi.core.InvestApi;

public class CommonInvestApiHelper {
    private static  String token;
    private static  String tokenAdmin;
    private static  InvestApi investApi;
    private static  InvestApi investApiAdmin;

    static {
        token = System.getProperty("investApiToken");
        tokenAdmin = System.getProperty("investApiTokenAdmin");
        investApi = InvestApi.create(token);
        investApiAdmin = InvestApi.create(tokenAdmin);
    }
    public static String getToken() {
        return token;
    }

    public static String getTokenAdmin() {
        return tokenAdmin;
    }

    public static InvestApi getInvestApiAdmin() {
        return investApiAdmin;
    }

    public static InvestApi getInvestApi() {
        return investApi;
    }
}
