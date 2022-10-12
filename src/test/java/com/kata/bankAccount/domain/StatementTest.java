package com.kata.bankAccount.domain;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class StatementTest {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	private final Statement statement = new Statement();

	@Test
	public void should_add_line_deposit() throws ParseException {
		Transaction transaction = new Transaction("DEPOSIT", dateFormat.parse("09/10/2022"),
				new BigDecimal(100.0));
		StatementLine statementLine = new StatementLine(transaction, new BigDecimal(100.0));		
		statement.addLine(statementLine);
		assertTrue(statement.contains(statementLine));
	}

	@Test
	public void should_add_line_withdraw() throws ParseException {
		Transaction transaction = new Transaction("WITHDRAW", dateFormat.parse("09/10/2022"),
				new BigDecimal(100.0));
		StatementLine statementLine = new StatementLine(transaction, new BigDecimal(100.0));
		statement.addLine(statementLine);
		assertTrue(statement.contains(statementLine));
	}

}
