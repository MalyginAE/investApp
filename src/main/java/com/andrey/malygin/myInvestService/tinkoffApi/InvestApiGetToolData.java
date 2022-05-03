package com.andrey.malygin.myInvestService.tinkoffApi;

import com.andrey.malygin.myInvestService.tinkoffApi.helpers.InvestApiHelper;
import ru.tinkoff.piapi.contract.v1.LastPrice;

import java.util.List;

public interface InvestApiGetToolData extends InvestApiHelper {
    LastPrice getLastPriceTool(String figi);
    List<LastPrice> getLastPriceTools(List<String> figi);
}
