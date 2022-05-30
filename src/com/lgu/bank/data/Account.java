package com.lgu.bank.data;

public class Account {
    private final int accountID;
    private final String accountName;

    private int balance;
    private final int accountType;

    public Account(int accountID, String accoundName, int balance, int accountType) {
        this.accountID = accountID;
        this.accountName = accoundName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
