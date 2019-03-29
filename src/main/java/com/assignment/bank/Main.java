package com.assignment.bank;

import java.util.Scanner;

public class Main extends Thread implements Runnable {

	private static final int ACCOUNTS_COUNT = 20;

	private static Bank bank = new Bank(ACCOUNTS_COUNT);
	private String accountNumber;
	private String option;
	private String amount;

	public Main(String accountNumber, String option, String amount) {
		this.accountNumber = accountNumber;
		this.option = option;
		this.amount = amount;
	}

	public static void main(String[] args) {

		do {
			System.out.println("Enter your Account_number: ");
			Scanner scanner = new Scanner(System.in);
			String accountNumber = scanner.nextLine();
			System.out.println("Chooese Option belwo Option");
			System.out.println("1: Deposit of Money");
			System.out.println("2: Widthwral of Money");
			scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			if (null != option && !"".equalsIgnoreCase(option)) {
				if (!"1".equals(option) && !"2".equals(option)) {
					System.out.println("Choose Option 1 or 2");
				} else {
					String operation = null;
					if ("1".equals(option)) {
						operation = "Deposit";
					} else if ("2".equals(option)) {
						operation = "Widthwral";
					}
					System.out.println("Enter Amount for " + operation);
					scanner = new Scanner(System.in);
					String amount = scanner.nextLine();
					System.out.println("Amount " + amount + " Selected for "
							+ operation);
					Main ts1 = new Main(accountNumber, option, amount);
					ts1.start();
				}
			} else {
				System.out.println("Choose Proper Option");
			}
		} while (true);

	}

	public void sleepTime() {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {

		}
	}

	@Override
	public void run() {
		Account account = bank.getAccount(accountNumber);
		if (null == account) {
			account = new Account(accountNumber);
			bank.addAccount(accountNumber, account);
		}

		System.out.println("#Before Transaction Account balance: "
				+ account.getBalance());
		if ("1".equalsIgnoreCase(option)) {
			account.deposit(Integer.parseInt(amount));
		} else if ("2".equalsIgnoreCase(option)) {
			account.withdraw(Integer.parseInt(amount));
		} else {
			System.out.println("Invalid Option");
		}
		System.out.println("#After Transaction Account balance: "
				+ account.getBalance());
		sleepTime();
	}
}