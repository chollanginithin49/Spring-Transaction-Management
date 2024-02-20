package com.demo.transaction.exception;

public class PaymentException extends RuntimeException{
    public PaymentException(String message)
    {
        super(message);
    }
}
