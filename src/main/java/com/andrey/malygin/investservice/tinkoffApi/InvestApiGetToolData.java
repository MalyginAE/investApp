package com.andrey.malygin.investservice.tinkoffApi;

import com.andrey.malygin.investservice.tinkoffApi.helpers.InvestApiHelper;
import ru.tinkoff.piapi.contract.v1.LastPrice;

import java.util.List;

public interface InvestApiGetToolData extends InvestApiHelper {
    LastPrice getLastPriceTool(String figi);
    List<LastPrice> getLastPriceTools(List<String> figi);
}
