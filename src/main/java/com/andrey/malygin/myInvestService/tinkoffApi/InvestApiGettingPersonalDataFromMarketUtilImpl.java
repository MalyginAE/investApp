package com.andrey.malygin.myInvestService.tinkoffApi;

import com.andrey.malygin.myInvestService.tinkoffApi.helpers.CommonInvestApiHelper;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.tinkoff.piapi.core.InvestApi;
import ru.tinkoff.piapi.core.models.Money;
import ru.tinkoff.piapi.core.models.Positions;
import ru.tinkoff.piapi.core.models.SecurityPosition;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class InvestApiGettingPersonalDataFromMarketUtilImpl implements InvestApiGettingPersonalDataFromMarketUtil {
    private static final InvestApi api = CommonInvestApiHelper.getInvestApi();

    @NotNull
    private  Positions getPositions() {
        var accounts = api.getUserService().getAccountsSync();
        var mainAccount = accounts.get(0).getId();
        //Получаем и печатаем список позиций
        return api.getOperationsService().getPositionsSync(mainAccount);
    }

    @Override
    public  List<Money> getListMoney() {
        Positions positions = getPositions();
        return positions.getMoney();
    }

    @Override
    public  List<SecurityPosition> getMyActivePosition() {
        Positions positions = getPositions();
        //        for (SecurityPosition security : securities) {
//            var figi = security.getFigi();
//            var balance = security.getBalance();
//            var blocked = security.getBlocked();
//            log.info("figi: {}, текущий баланс: {}, заблокировано: {}", figi, balance, blocked);
        return positions.getSecurities();
    }
}
