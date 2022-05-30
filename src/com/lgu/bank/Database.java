package com.lgu.bank;

import java.util.LinkedHashMap;
import java.util.Map;

public class Database {
    //DB는 추후 MySQL로 변경예정
    //지금은 linked hashmap
    private Map<Integer, Account> db = new LinkedHashMap<Integer, Account>();
    private static Database sInstance; //싱글톤 패턴
    private Database() {}

    private static Database getInstance() {
        if (sInstance == null) sInstance = new Database();
        return sInstance;
    }


    public static Map<Integer, Account> getDb() {
        return getInstance().db;
    }
}
