package com.andrey.malygin.myInvestService.tinkoffApi.helpers;


public interface InvestApiHelper {
//    final Map<Ticker, String> STRING_MAP = new HashMap<>(Map.of(
//
//    ));
    default String getFIGI(Ticker ticker){

        return "";
    }
    default String getToken(boolean isReadOnly){
        String token = System.getProperty("investApiToken");
        String tokenAdmin = System.getProperty("investApiTokenAdmin");
        return isReadOnly ? token : tokenAdmin;
    }
}
