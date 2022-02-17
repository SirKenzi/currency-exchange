package marcin.currencyexchange.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExchangeRate {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private LocalDate date;
    private BigDecimal rate;
    private String countryCode;

    public ExchangeRate(){}

    public ExchangeRate(LocalDate date, BigDecimal rate, String countryCode){
        this.date = date;
        this.rate = rate;
        this.countryCode = countryCode;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public BigDecimal getRate(){
        return this.rate;
    }

    public String getCountryCode(){
        return this.countryCode;
    }

}
