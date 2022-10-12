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
		Transaction transaction = new Transaction(TransactionType.DEPOSIT, date, amount);
		balance = transaction.balanceAfterTransaction(balance);
		StatementLine statementLine = new StatementLine(transaction, balance);
		statement.addLine(statementLine);
	}

	public void withdraw(Date date, BigDecimal amount) {
		if(amount.compareTo(balance) == 1)
			throw new IllegalArgumentException(String.format("Should not withdraw amount %s more than balance %s", amount, balance));
		Transaction transaction = new Transaction(TransactionType.WITHDRAW, date, amount.negate());
		balance = transaction.balanceAfterTransaction(balance);
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
