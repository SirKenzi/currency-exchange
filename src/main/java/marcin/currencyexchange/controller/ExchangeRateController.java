package marcin.currencyexchange.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import marcin.currencyexchange.model.ExchangeRate;
import marcin.currencyexchange.service.exchangerate.ExchangeRateService;

@RestController
public class ExchangeRateController {
    
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/exchange-rate/{date}/{currency}")
    ResponseEntity<ExchangeRate> get(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable("currency") String currency){
        ExchangeRate exchangeRate = exchangeRateService.get(date,currency);
        return new ResponseEntity<ExchangeRate>(exchangeRate, HttpStatus.OK);
    }

}