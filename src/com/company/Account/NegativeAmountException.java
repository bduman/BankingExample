package com.company.Account;

public class NegativeAmountException extends AccountException {
    NegativeAmountException() {
        super("Eksi miktarda para yatırılamaz/çekilemez.");
    }
}
