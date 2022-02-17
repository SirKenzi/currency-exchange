package marcin.currencyexchange.dto.nbp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class NbpRate {
    
    private String no;
    private String effectiveDate;
    private String mid;

    public void setNo(String no){
        this.no = no;
    }

    public void setEffectiveDate(String effectiveDate){
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveDate(){
        return this.effectiveDate;
    }

    public void setMid(String mid){
        this.mid = mid;
    }

    public String getMid(){
        return this.mid;
    }


}
