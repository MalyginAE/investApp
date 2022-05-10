package com.andrey.malygin.investservice.tinkoffApi;

import org.springframework.stereotype.Service;
import ru.tinkoff.piapi.contract.v1.LastPrice;
import ru.tinkoff.piapi.core.InvestApi;

import java.util.Collections;
import java.util.List;
@Service
public class InvestApiGetToolDataImpl implements InvestApiGetToolData {
    private  static String token ;
    private static final InvestApi api = InvestApi.create(token);

    @Override
    public LastPrice getLastPriceTool(String figi) {
        var lastPrices = api.getMarketDataService().getLastPricesSync(Collections.singleton(figi));
        return lastPrices.get(0);
    }

    @Override
    public List<LastPrice> getLastPriceTools(List<String> figies) {
        return api.getMarketDataService().getLastPricesSync(figies);
    }
}
