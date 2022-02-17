package marcin.currencyexchange.util;

public class BadRequestException extends RuntimeException{

    public BadRequestException(){
        super("Request to NBP service ended in failure");
    }
    
}
