package marcin.currencyexchange.service.exchangerate.provider;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import marcin.currencyexchange.dto.nbp.NbpExchangeRate;
import marcin.currencyexchange.model.ExchangeRate;

@Service
public class NbpExchangeRateProviderService implements RemoteExchangeRateProvider{

    private final RestTemplate restTemplate;

    @Value( "${exchangerate.url}")
    private String exchangeRateRemoteUrl;

    public NbpExchangeRateProviderService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.errorHandler(new NbpResponseErrorHandler()).build();
   }

    @Override
    public ExchangeRate getExchangeRate(LocalDate date, String country) {
        ResponseEntity<NbpExchangeRate> exchangeRateResponse = this.restTemplate.getForEntity(getRemoteUrl(), NbpExchangeRate.class, country, date);
        ExchangeRate exchangeRate = null;
        if( exchangeRateResponse.getStatusCode() == HttpStatus.OK ){
            NbpExchangeRate nbpExchangeRate = exchangeRateResponse.getBody();
            BigDecimal rate = new BigDecimal(nbpExchangeRate.getRates().get(0).getMid());
            LocalDate rateDate = LocalDate.parse(nbpExchangeRate.getRates().get(0).getEffectiveDate());
            exchangeRate = new ExchangeRate(rateDate, rate, nbpExchangeRate.getCode());
        }
        return exchangeRate;
    }

    @Override
    public String getRemoteUrl() {
        return this.exchangeRateRemoteUrl;
    }
    
}
