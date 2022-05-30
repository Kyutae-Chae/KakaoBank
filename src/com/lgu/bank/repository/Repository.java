package com.lgu.bank.repository;

import com.lgu.bank.data.Account;
import com.lgu.bank.data.AccountType;
import com.lgu.bank.data.IUserAction;
import com.lgu.bank.db.Database;

import java.util.Map;

public class Repository implements IUserAction {

    public static int sIncreasedAccountId;
    private static Repository sInstance; //싱글톤 패턴
    private Repository() {}

    public static Repository getInstance() {
        if (sInstance == null) sInstance = new Repository();
        return sInstance;
    }

    @Override
    public boolean deposit(int accountId, int amount) {
        //입금
        Account account = Database.getDb().get(accountId);
        if (account.getAccountType() == AccountType.TYPE_TERM_DEPOSIT) return false;
        Database.getDb().put(accountId,
                new Account(accountId,
                        account.getAccountName(),
                        account.getBalance() + amount,
                        account.getAccountType()));
        return true;
    }


    @Override
    public boolean withdraw(int accountId, int amount) {
        //출금
        Account account = Database.getDb().get(accountId);
        if (account.getAccountType() == AccountType.TYPE_TERM_DEPOSIT) return false;
        if (account.getBalance() < amount) return false;
        Database.getDb().put(accountId,
                new Account(accountId,
                        account.getAccountName(),
                        account.getBalance() - amount,
                        account.getAccountType()));
        return true;
    }

    @Override
    public int getBalance(int accountId) {
        //잔고조회
        return Database.getDb().get(accountId).getBalance();
    }

    @Override
    public int getMaturedAmount(int accountId) {
        //정기예금
        //TO-DO
        return 0;
    }

    //계좌생성
    public boolean createAccount(String accountName, int accountType){
        boolean ret = false;
        sIncreasedAccountId = sIncreasedAccountId + 1;
        Account account = new Account(sIncreasedAccountId, accountName, 0, accountType);

        Database.getDb().put(sIncreasedAccountId, account);
        return ret;
    }

    public int getAccountIdByName(String accountName) {
        //입금
        Map<Integer, Account> map = Database.getDb();
        for (Map.Entry<Integer, Account> entry : map.entrySet()) {
            if (entry.getValue().getAccountName().equals(accountName)) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
