package com.andrey.malygin.investservice.tinkoffApi;

import com.andrey.malygin.investservice.tinkoffApi.helpers.CommonInvestApiHelper;
import org.springframework.stereotype.Service;
import ru.tinkoff.piapi.contract.v1.CandleInterval;
import ru.tinkoff.piapi.contract.v1.HistoricCandle;
import ru.tinkoff.piapi.contract.v1.LastPrice;
import ru.tinkoff.piapi.core.InvestApi;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
@Service
public class InvestApiGetToolDataImpl implements InvestApiGetToolData {
    private static final InvestApi api = CommonInvestApiHelper.getInvestApi();

    @Override
    public LastPrice getLastPriceTool(String figi) {
        var lastPrices = api.getMarketDataService().getLastPricesSync(Collections.singleton(figi));
        return lastPrices.get(0);
    }

    @Override
    public List<LastPrice> getLastPriceTools(List<String> figies) {
        return api.getMarketDataService().getLastPricesSync(figies);
    }

    public static void main(String[] args) throws InterruptedException {
        var candlesDay = api.getMarketDataService()
                .getCandlesSync("BBG004730N88", Instant.now().minus(1, ChronoUnit.DAYS), Instant.now(), CandleInterval.CANDLE_INTERVAL_DAY);
        for (HistoricCandle historicCandle : candlesDay) {
            System.out.println(historicCandle.getClose().getNano());
        }

    }
}
