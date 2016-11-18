package com.company.Account;

class AccountException extends Exception {
    AccountException(String message) {
        super("[Hata] " + message);
    }
}
