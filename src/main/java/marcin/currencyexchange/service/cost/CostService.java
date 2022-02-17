package marcin.currencyexchange.service.cost;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import marcin.currencyexchange.dto.Cost;
import marcin.currencyexchange.dto.CostToCalculate;
import marcin.currencyexchange.model.ExchangeRate;
import marcin.currencyexchange.service.exchangerate.ExchangeRateService;

@Service
public class CostService {

    private final ExchangeRateService exchangeRateService;

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateService.class);

    public CostService(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    public Cost calculate(CostToCalculate costToCalculate){
        
        BigDecimal totalCostInPLN = new BigDecimal("0");

        log.info("Calculating total cost");

        for( Cost amount : costToCalculate.getAmounts()){
            ExchangeRate exchangeRate = exchangeRateService.get(costToCalculate.getDate(), amount.getCode());
            totalCostInPLN = totalCostInPLN.add(exchangeRate.getRate().multiply(amount.getAmount())); 
        }

        Cost resultingCost = new Cost();
        resultingCost.setAmount(totalCostInPLN);
        resultingCost.setCode("PLN");

        log.info("Total cost amounts to " + totalCostInPLN.toString());
        return resultingCost;
    }
    
}
