package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException burgerException) {

        // 'BurgerErrorResponse' nesnesi oluşturuluyor
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(
                burgerException.getMessage()
        );
        // Hata yanıtı ile birlikte HTTP yanıtı (ResponseEntity) döndürülüyor
        return new ResponseEntity<>(errorResponse, burgerException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {

        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
