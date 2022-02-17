package marcin.currencyexchange.service.exchangerate.provider;

public interface RemoteExchangeRateProvider extends ExchangeRateProvider{
    
    abstract String getRemoteUrl();
    

}
