package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Account {

	private BigDecimal balance;

	public Account() {
		balance = BigDecimal.ZERO;
	}

	public void deposit(Date date, BigDecimal amount) {
		if(amount.compareTo(BigDecimal.ZERO) == -1) 
			throw new IllegalArgumentException(String.format("Should not deposit a negative amount: %s", amount));
		balance = balance.add(amount);
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
