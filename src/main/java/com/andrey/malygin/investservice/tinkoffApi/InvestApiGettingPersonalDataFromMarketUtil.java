package com.andrey.malygin.investservice.tinkoffApi;

import com.andrey.malygin.investservice.tinkoffApi.helpers.InvestApiHelper;
import ru.tinkoff.piapi.core.models.Money;
import ru.tinkoff.piapi.core.models.SecurityPosition;

import java.util.List;

public interface InvestApiGettingPersonalDataFromMarketUtil extends InvestApiHelper {
    // мои деньги на счету

      List<Money> getListMoney();

    //  мои купленные акции

      List<SecurityPosition> getMyActivePosition();
}
