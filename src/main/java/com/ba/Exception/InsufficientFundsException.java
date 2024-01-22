package com.ba.Exception;
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds for transaction");
    }
}
