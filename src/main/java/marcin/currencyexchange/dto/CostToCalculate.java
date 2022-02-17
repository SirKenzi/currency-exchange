package marcin.currencyexchange.dto;

import java.time.LocalDate;
import java.util.Set;

public class CostToCalculate {
    
    LocalDate date;
    Set<Cost> amounts;

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setAmounts(Set<Cost> amounts){
        this.amounts = amounts;
    }

    public LocalDate getDate(){
        return date;
    }

    public Set<Cost> getAmounts(){
        return amounts;
    }

}
