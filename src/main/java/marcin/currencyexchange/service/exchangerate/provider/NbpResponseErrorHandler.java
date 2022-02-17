package marcin.currencyexchange.service.exchangerate.provider;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import marcin.currencyexchange.util.BadRequestException;

public class NbpResponseErrorHandler implements ResponseErrorHandler {
    
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new BadRequestException();
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return true;
    }

}
