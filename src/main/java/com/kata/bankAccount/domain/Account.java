package com.kata.bankAccount.domain;

import java.math.BigDecimal;

public class Account {

	private BigDecimal balance;

	public Account() {
		balance = BigDecimal.ZERO;
	}

	public void deposit(String date, BigDecimal amount) {
		balance = balance.add(amount);
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
