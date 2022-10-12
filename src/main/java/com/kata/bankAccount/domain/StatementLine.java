package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class StatementLine {
	private final Transaction transaction;
	private final BigDecimal currentBalance;

	public StatementLine(final Transaction transaction, final BigDecimal currentBalance) {
		this.transaction = transaction;
		this.currentBalance = currentBalance;
	}

	public String type() {
		return transaction.getType();
	}

	public BigDecimal amount() {
		return transaction.getAmount();
	}

	public Date date() {
		return transaction.getDate();
	}

	public BigDecimal balance() {
		return currentBalance;
	}

}
