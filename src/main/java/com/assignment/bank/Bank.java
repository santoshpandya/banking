package com.assignment.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Bank {
    private static Map<String, Account> accountMap = new ConcurrentHashMap<String, Account>();

    public void addAccount(String accountNumber, Account account) {
		accountMap.put(accountNumber, account);
	}

	public Bank(int accountsCount) {
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

}