package com.assignment.bank;

public class Account {
	private int balance = 1000;
	private String number;

	public Account(String number) {
		this.number = number;
	}

	public synchronized int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int bal) {
		try {

			if (balance >= bal) {
				System.out.println("Current Balance- " + balance
						+ " : Widthwral Value-" + bal);

				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance - bal;
			} else {
				System.out
						.println("doesn't have enough money for withdraw  from account "
								+ number);
			}
			System.out.println(" withdrawal value: " + balance
					+ " from account " + number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(int bal) {
		try {
			if (bal > 0) {
				System.out.println("trying to deposit on account " + number);
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance = balance + bal;
			} else {
				System.out
						.println(" doesn't have enough money for deposit on account "
								+ number);
			}
			System.out.println(" deposited " + balance + " on account "
					+ number);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Account " + number + " balance: " + balance;
	}
}