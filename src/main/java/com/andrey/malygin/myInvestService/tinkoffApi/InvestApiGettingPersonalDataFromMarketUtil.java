package com.andrey.malygin.myInvestService.tinkoffApi;

import ru.tinkoff.piapi.core.models.Money;
import ru.tinkoff.piapi.core.models.SecurityPosition;

import java.util.List;

public interface InvestApiGettingPersonalDataFromMarketUtil {
    // мои деньги на счету

      List<Money> getListMoney();

    //  мои купленные акции

      List<SecurityPosition> getMyActivePosition();
}
