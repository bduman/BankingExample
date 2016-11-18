package com.company;

import com.company.Account.*;
import com.company.BankOffice.BankOffice;

public class TestSoru1 {

    public static void main(String[] args) {

        Account testAcc = new Account(12315, 532.12);
        Account testAccCopy = null;

        // withdraw, deposit
        try {
            testAcc.withdraw(432);
            testAcc.deposit(11.11);
        } catch (NegativeAmountException e1) {
            System.out.println(e1.getMessage());
        } catch (InsufficientFundException e2) {
            System.out.println(e2.getMessage() + "!");
        }

        System.out.println(testAcc.getBalance());
        // toString
        System.out.println(testAcc);
        System.out.println(testAcc.getId());
        // clone
        try {
            testAccCopy = (Account) testAcc.clone();
            System.out.println(testAccCopy);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        // equals
        if (testAccCopy != null && testAcc.equals(testAccCopy)) {
            System.out.println("Kopya nesne eşit.");
        }

        try {
            if (testAccCopy != null) {
                testAccCopy.deposit(11.31);
            }
        } catch (NegativeAmountException e) {
            e.getMessage();
        }

        // bank
        BankOffice testBank;
        BankOffice testBankCopy;
        testBank = new BankOffice("Abc Bankası", "Bornova", "Ege Uni Kampus");
        testBank.addAccount(testAcc);
        testBank.addAccount(testAccCopy);
        // toString
        System.out.println(testBank);
        // get methods
        System.out.println(testBank.getBankaAd());
        System.out.println(testBank.getSubeAd());
        System.out.println(testBank.getSubeAdres());

        try {
            // clone
            testBankCopy = (BankOffice) testBank.clone();
            // equals
            if (testBankCopy.equals(testBank)) {
                System.out.println("Bankalar aynı.");
            }
        } catch (CloneNotSupportedException e) {
            e.getMessage();
        }
    }
}
