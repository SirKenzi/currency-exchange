package marcin.currencyexchange.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import marcin.currencyexchange.dto.Cost;
import marcin.currencyexchange.dto.CostToCalculate;
import marcin.currencyexchange.service.cost.CostService;

@RestController
public class CostController {
    
    private final CostService costService;

    public CostController(CostService costService){
        this.costService = costService;
    }

    @PostMapping("/cost")
    ResponseEntity<Cost> calculate(@RequestBody CostToCalculate costToCalculate){
        Cost exchangeRate = costService.calculate(costToCalculate);
        return new ResponseEntity<Cost>(exchangeRate, HttpStatus.OK);
    }

}
