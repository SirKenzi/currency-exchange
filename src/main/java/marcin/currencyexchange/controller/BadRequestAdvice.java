package marcin.currencyexchange.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import marcin.currencyexchange.util.BadRequestException;

@ControllerAdvice
public class BadRequestAdvice {
    
    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String characterNotFoundHandler(BadRequestException ex) {
      return ex.getMessage();
    }

}
