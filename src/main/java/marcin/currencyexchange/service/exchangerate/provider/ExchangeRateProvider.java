package marcin.currencyexchange.service.exchangerate.provider;

import java.time.LocalDate;

import marcin.currencyexchange.model.ExchangeRate;

public interface ExchangeRateProvider {
    
    ExchangeRate getExchangeRate(LocalDate date, String country);

}
