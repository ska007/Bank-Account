package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private TransactionType type;
	private Date date;
	private BigDecimal amount;

	public Transaction(TransactionType type, Date date, BigDecimal amount) {
		this.type = type;
		this.date = date;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal balanceAfterTransaction(BigDecimal currentBalance) {
		return currentBalance = currentBalance.add(amount);
	}
}
