package com.company.BankOffice;

import com.company.Account.Account;
import java.util.ArrayList;
import java.util.Arrays;

public class BankOffice {

    private String bankaAd;
    private String subeAd;
    private String subeAdres;
    private Account[] accounts = null;

    public BankOffice(String bankaAd, String subeAd, String subeAdres) {
        this.setBankaAd(bankaAd);
        this.setSubeAd(subeAd);
        this.setSubeAdres(subeAdres);
    }

    public BankOffice(String bankaAd, String subeAd, String subeAdres, Account[] accounts) {
        this.setBankaAd(bankaAd);
        this.setSubeAd(subeAd);
        this.setSubeAdres(subeAdres);

        for (Account account : accounts) {
            this.addAccount(account);
        }
    }

    public String getBankaAd() {
        return this.bankaAd;
    }

    public String getSubeAd() {
        return this.subeAd;
    }

    public String getSubeAdres() {
        return this.subeAdres;
    }

    public Account[] getAccounts() {
        return this.accounts;
    }

    private void setBankaAd(String bankaAd) {
        this.bankaAd = bankaAd;
    }

    private void setSubeAd(String subeAd) {
        this.subeAd = subeAd;
    }

    private void setSubeAdres(String subeAdres) {
        this.subeAdres = subeAdres;
    }
    // return: bool, if success, true
    public boolean addAccount(Object newAccount) {
        if (newAccount != null && newAccount instanceof Account) {
            this.addAccountToArray((Account) newAccount);
            return true;
        }
        return false;
    }

    private void addAccountToArray(Account newAccount) {
        ArrayList<Account> temp;
        temp = (this.accounts != null) ?
                new ArrayList<>(Arrays.asList(this.accounts)) :
                new ArrayList<>();

        temp.add(newAccount);
        this.accounts =  temp.toArray(new Account[temp.size()]);
    }

    @Override
    public String toString() {
        String str = String.format("{%s} bankasındaki (Şube: %s, Adres: %s) hesaplar \n\n", this.getBankaAd(),
                this.getSubeAd(), this.getSubeAdres());

        for (Account account : this.accounts) {
            str = str.concat(account.toString() + "\n");
        }

        return str;
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof BankOffice) {
            BankOffice otherBank = (BankOffice) other;
            if (otherBank.getBankaAd().equals(this.getBankaAd()) &&
                otherBank.getSubeAd().equals(this.getSubeAd()) &&
                otherBank.getSubeAdres().equals(this.getSubeAdres()) &&
                Arrays.equals(otherBank.getAccounts(), this.getAccounts()))
                return true;
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new BankOffice(this.getBankaAd(), this.getSubeAd(), this.getSubeAdres(), this.getAccounts());
    }
}
