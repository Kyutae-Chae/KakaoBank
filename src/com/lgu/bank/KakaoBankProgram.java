package com.lgu.bank;

import com.lgu.bank.data.AccountType;
import com.lgu.bank.repository.Repository;

public class KakaoBankProgram {
    public static void main(String[] args) {
        createAccount("홍길동", AccountType.TYPE_NORMAL_DEPOSIT);
//        int accountId = Repository.getInstance().getAccountIdByName("홍길동");
//        if (accountId > 0) {
//            Repository.getInstance().deposit(accountId, 10000000);
//            System.out.printf("잔고 : %,d원\n", Repository.getInstance().getBalance(accountId));
//        }
        deposit("홍길동", 10000000);
        createAccount("엄준승", AccountType.TYPE_NORMAL_DEPOSIT);
        withdraw("엄준승", 1000);
        deposit("엄준승", 2000000000);
    }

    public static void createAccount(String accountName, int accountType) {
        Repository.getInstance().createAccount(accountName, accountType);
        System.out.println(accountName + "님의 계좌가 생성되었습니다. 잔고(0원)");
    }

    public static void deposit(String accountName, int amount) {
        int accountId = Repository.getInstance().getAccountIdByName(accountName);
        if (accountId < 0) {
            System.out.println("등록된 계좌 정보가 없습니다.");
            return;
        }
        if (Repository.getInstance().deposit(accountId, amount))
            System.out.printf("%s님의 계좌에 %,d원이 입금되었습니다.(잔고:%,d원)\n", accountName, amount, Repository.getInstance().getBalance(accountId));
        else
            System.out.println("입금이 불가능한 계좌입니다.");
    }

    public static void withdraw(String accountName, int amount) {
        int accountId = Repository.getInstance().getAccountIdByName(accountName);
        if (accountId < 0) {
            System.out.println("등록된 계좌 정보가 없습니다.");
            return;
        }
        if (Repository.getInstance().withdraw(accountId, amount))
            System.out.printf("%s님의 계좌에서 %,d원이 출금되었습니다.(잔고:%,d원)\n", accountName, amount, Repository.getInstance().getBalance(accountId));
        else
            System.out.println("출금이 불가합니다.");
    }
    public static void checkBalance(String accountName) {
        int accountId = Repository.getInstance().getAccountIdByName(accountName);
        if (accountId < 0) {
            System.out.println("등록된 계좌 정보가 없습니다.");
            return;
        }
            System.out.printf("%s님의 계좌에 %,d원이 있습니다.\n", accountName, Repository.getInstance().getBalance(accountId));
    }
}
