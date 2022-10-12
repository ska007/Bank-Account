package com.kata.bankAccount.format;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.kata.bankAccount.domain.StatementLine;
import com.kata.bankAccount.domain.Transaction;
import com.kata.bankAccount.domain.TransactionType;

public class StatementLineFormatterTest {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

	@Test
	public void should_print_a_formatted_statement_line_deposit() throws ParseException {
		final StatementLineFormatter statementLineFormatter = new StatementLineFormatter();
		assertEquals(statementLineFormatter.format(new StatementLine(
				new Transaction(TransactionType.DEPOSIT, dateFormat.parse("09/10/2022"), new BigDecimal(100.0)),
				new BigDecimal(100.0))), "DEPOSIT | 09/10/2022 | 100 | 100" + System.lineSeparator());
	}
	
	@Test
	public void should_print_a_formatted_statement_line_withdraw() throws ParseException {
		final StatementLineFormatter statementLineFormatter = new StatementLineFormatter();
		assertEquals(statementLineFormatter.format(new StatementLine(
				new Transaction(TransactionType.WITHDRAW, dateFormat.parse("09/10/2022"), new BigDecimal(100.0)),
				BigDecimal.ZERO)), "WITHDRAW | 09/10/2022 | 100 | 0" + System.lineSeparator());
	}

}
