package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Account {

	private BigDecimal balance;

	public Account() {
		balance = BigDecimal.ZERO;
	}

	public void deposit(Date date, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1)
			throw new IllegalArgumentException(String.format("Should not deposit a negative amount: %s", amount));
		balance = balance.add(amount);
	}

	public void withdraw(Date date, BigDecimal amount) {
		if(amount.compareTo(balance) == 1)
			throw new IllegalArgumentException(String.format("Should not withdraw amount %s more than balance %s", amount, balance));
		balance = balance.add(amount.negate());
	}

	public BigDecimal getBalance() {
		return balance;
	}

}
