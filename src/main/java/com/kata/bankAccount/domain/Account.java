package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Account {

	private BigDecimal balance;
	private final IStatementPrinter statementPrinter;
	private final Statement statement = new Statement();

	public Account(IStatementPrinter statementPrinter) {
		this.statementPrinter = statementPrinter;
		balance = BigDecimal.ZERO;	
	}

	public void deposit(Date date, BigDecimal amount) {
		if (amount.compareTo(BigDecimal.ZERO) == -1)
			throw new IllegalArgumentException(String.format("Should not deposit a negative amount: %s", amount));
		balance = balance.add(amount);
		Transaction transaction = new Transaction("DEPOSIT", date, amount);
		StatementLine statementLine = new StatementLine(transaction, balance);
		statement.addLine(statementLine);
	}

	public void withdraw(Date date, BigDecimal amount) {
		if(amount.compareTo(balance) == 1)
			throw new IllegalArgumentException(String.format("Should not withdraw amount %s more than balance %s", amount, balance));
		balance = balance.add(amount.negate());
		Transaction transaction = new Transaction("WITHDRAW", date, amount.negate());
		StatementLine statementLine = new StatementLine(transaction, balance);
		statement.addLine(statementLine);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void printStatement() {
		statementPrinter.print(statement);
	}

}
