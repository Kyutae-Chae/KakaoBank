package com.lgu.bank;

public interface IUserAction {
    abstract public boolean deposit(int accountId, int amount);
    abstract public boolean withdraw(int accountId, int amount);
    abstract public int getBalance(int accountId);
    abstract public int getMaturedAmount(int accountId);
}
