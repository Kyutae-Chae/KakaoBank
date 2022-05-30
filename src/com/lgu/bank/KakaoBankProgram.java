package com.lgu.bank;

public class KakaoBankProgram {
    public static void main(String[] args) {
        Repository.getInstance().createAccount("홍길동", AccountType.TYPE_NORMAL_DEPOSIT);
        int accountId = Repository.getInstance().getAccountIdByName("홍길동");
        if (accountId > 0) {
            Repository.getInstance().deposit(accountId, 10000000);
            System.out.printf("잔고 : %,d원\n", Repository.getInstance().getBalance(accountId));
        }

        Repository.getInstance().createAccount("엄준승", AccountType.TYPE_NORMAL_DEPOSIT);
        accountId = Repository.getInstance().getAccountIdByName("엄준승");
        if (accountId > 0) {
            Repository.getInstance().deposit(accountId, 2000000000);
            System.out.printf("잔고 : %,d원\n", Repository.getInstance().getBalance(accountId));
        }
    }
}
