package marcin.currencyexchange.dto.nbp;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class NbpExchangeRate {
    
    private String table;
    private String currency;
    private String code;
    private List<NbpRate> rates;

    public void setTable(String table){
        this.table = table;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public void setRates(List<NbpRate> rates){
        this.rates = rates;
    }

    public List<NbpRate> getRates(){
        return this.rates;
    }

    @Override
    public String toString(){
        return table + " " + currency + " " + code;
    }
}
