package com.f_lab.java_commerce.exception;

public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException() {
        super("재고가 부족합니다.");
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
