package com.company.Account;

public class InsufficientFundException extends AccountException {
    InsufficientFundException() {
        super("Yetersiz bakiye.");
    }
}
