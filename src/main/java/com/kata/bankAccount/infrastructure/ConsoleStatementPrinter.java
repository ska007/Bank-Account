package com.kata.bankAccount.infrastructure;

import com.kata.bankAccount.domain.IConsole;
import com.kata.bankAccount.domain.IStatementPrinter;
import com.kata.bankAccount.domain.Statement;
import com.kata.bankAccount.domain.StatementLine;
import com.kata.bankAccount.format.StatementLineFormatter;

public class ConsoleStatementPrinter implements IStatementPrinter {
	
	private final StatementLineFormatter statementLineFormatter;
	private IConsole console;

	public ConsoleStatementPrinter(final StatementLineFormatter statementLineFormatter, final IConsole console) {
		this.statementLineFormatter = statementLineFormatter;
		this.console = console;
	}

	@Override
	public void print(Statement statement) {
		for (StatementLine statementLine : statement) {
			console.printLine(statementLineFormatter.format(statementLine));
		}
	}
}
