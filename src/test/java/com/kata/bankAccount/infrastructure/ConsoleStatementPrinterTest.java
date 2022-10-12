package com.kata.bankAccount.infrastructure;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.kata.bankAccount.domain.Statement;
import com.kata.bankAccount.domain.StatementLine;
import com.kata.bankAccount.domain.IConsole;
import com.kata.bankAccount.domain.IStatementPrinter;
import com.kata.bankAccount.domain.Transaction;
import com.kata.bankAccount.format.StatementLineFormatter;

public class ConsoleStatementPrinterTest {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	private StatementLineFormatter statementLineFormatter;
	private IStatementPrinter statementPrinter = null;
	private Statement statement;
	private IConsole console;

	@Before
	public void setUp() {
		statementLineFormatter = mock(StatementLineFormatter.class);
		console = mock(Console.class);
		statementPrinter = new ConsoleStatementPrinter(statementLineFormatter, console);
		statement = new Statement();
	}

	@Test
	public void should_ask_to_format_a_statement_line() throws ParseException {
		StatementLine statementLine = new StatementLine(
				new Transaction("DEPOSIT", dateFormat.parse("09/10/2022"), new BigDecimal(100.0)),
				new BigDecimal(100.0));

		statement.addLine(statementLine);
		statementPrinter.print(statement);

		verify(statementLineFormatter).format(statementLine);
	}

	@Test
	public void print_a_formatted_line() throws ParseException {
		final String formattedStatementLine =   "DEPOSIT | 09/10/2022 | 100 | 100" + System.lineSeparator();
		when(statementLineFormatter.format(any(StatementLine.class))).thenReturn(formattedStatementLine);
		StatementLine statementLine = new StatementLine(
				new Transaction("DEPOSIT", dateFormat.parse("09/10/2022"), new BigDecimal(100.0)),
				new BigDecimal(100.0));
		
		statement.addLine(statementLine);
		statementPrinter.print(statement);

		verify(console).printLine(formattedStatementLine);
	}

}
