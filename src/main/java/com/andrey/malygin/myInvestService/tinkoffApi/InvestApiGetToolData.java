package com.andrey.malygin.myInvestService.tinkoffApi;

import ru.tinkoff.piapi.contract.v1.LastPrice;

import java.util.List;

public interface InvestApiGetToolData {
    LastPrice getLastPriceTool(String figi);
    List<LastPrice> getLastPriceTools(List<String> figi);
}
