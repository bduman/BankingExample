package com.company.Account;

public class Account implements Cloneable {

    private int id; // hesap numarası
    private double balance; // hesaptaki para miktarı

    public Account(int id, double balance) {
        this.setId(id);
        this.setBalance(balance);
    }
    /*
    public Account(Account other) {
        this.setId(other.getId());
        this.setBalance(other.getBalance());
    }
    */
    private void setId(int id) {
        // TODO: belli bir formata göre filtre uygulanabilir
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    private double setBalance(double newBalance) {
        this.balance = newBalance < 0 ? 0 : newBalance;
        return this.getBalance();
    }
    /*
    double decrease: must positive
    return: this.balance
    */
    public double deposit(double increase) throws NegativeAmountException {
        if (increase < 0)
            throw new NegativeAmountException();

        return this.setBalance(this.getBalance() + increase);
    }
    /*
    double decrease: must positive
    return: this.balance
    */
    public double withdraw(double decrease) throws NegativeAmountException, InsufficientFundException {
        if (decrease < 0)
            throw new NegativeAmountException();
        if (this.getBalance() < decrease)
            throw new InsufficientFundException();

        return this.setBalance(this.getBalance() - decrease);
    }

    @Override
    public String toString() {
        return String.format("{%s} hesap numaralı hesabın bakiyesi {%s TL}", this.getId(), this.getBalance());
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof Account) {
            Account otherAcc = (Account) other;
            if (otherAcc.getId() == this.getId())
                return true;
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
