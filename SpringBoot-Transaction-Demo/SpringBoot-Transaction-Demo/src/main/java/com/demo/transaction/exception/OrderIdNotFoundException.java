package com.demo.transaction.exception;

public class OrderIdNotFoundException extends RuntimeException{
    public OrderIdNotFoundException(String message)
    {
        super(message);
    }
}
