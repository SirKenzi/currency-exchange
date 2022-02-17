package marcin.currencyexchange.service.exchangerate;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import marcin.currencyexchange.model.ExchangeRate;
import marcin.currencyexchange.repository.ExchangeRateRepository;
import marcin.currencyexchange.service.exchangerate.provider.ExchangeRateProvider;

@Service
public class ExchangeRateService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateService.class);
    
    private final ExchangeRateRepository exchangeRateRepository;
    private final ExchangeRateProvider exchangeRateProvider;

    public ExchangeRateService(ExchangeRateRepository exchangeRateRepository, ExchangeRateProvider exchangeRateProvider){
        this.exchangeRateRepository = exchangeRateRepository;
        this.exchangeRateProvider = exchangeRateProvider;
    }

    public ExchangeRate get(LocalDate date, String countryCode){
        log.info("Requesting exchange rate for country " + countryCode + " and date " + date);
        Optional<ExchangeRate> optionalExchangeRate = exchangeRateRepository.findByDateAndCountryCode(date, countryCode);
        ExchangeRate exchangeRate = null;
        if( !optionalExchangeRate.isPresent()){
            log.info("Exchange rate for " + countryCode + " and date " + date + " could not be found in local database.");
            exchangeRate = exchangeRateProvider.getExchangeRate(date, countryCode);
            if (exchangeRate != null ){
                log.info("Exchange Rate for " + countryCode + " and date " + date + " was retreived from remote source.");
                exchangeRate = exchangeRateRepository.save(exchangeRate);
            }
        } else{
            log.info("Exchange rate for " + countryCode + " and date " + date + " was found in local database.");
            exchangeRate = optionalExchangeRate.get();
        }
        return exchangeRate;
    }

}
