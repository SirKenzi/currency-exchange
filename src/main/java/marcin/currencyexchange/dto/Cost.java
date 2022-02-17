package marcin.currencyexchange.dto;

import java.math.BigDecimal;

public class Cost {
    
    private BigDecimal amount;
    private String code;

    public Cost(){}

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public void setCode(String code){
        this.code = code;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public String getCode(){
        return this.code;
    }

}
