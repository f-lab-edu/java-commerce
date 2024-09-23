package com.f_lab.java_commerce.exception;

import org.springframework.http.HttpStatus;

public class NotEnoughStockException extends BaseException {

    public NotEnoughStockException() {
        super(HttpStatus.BAD_REQUEST, "재고가 부족합니다.");
    }

    public NotEnoughStockException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
