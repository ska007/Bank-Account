package com.kata.bankAccount.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class TransactionTest {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

	@Test
	public void should_calculate_current_balance_after_deposit() throws ParseException {
		Transaction transaction = new Transaction(TransactionType.DEPOSIT, dateFormat.parse("07/10/2022"),
				new BigDecimal(100.0));
		assertEquals(new BigDecimal(100.0), transaction.balanceAfterTransaction(BigDecimal.ZERO));
	}

	@Test
	public void should_calculate_current_balance_after_withdrawal() throws ParseException {
		Transaction transaction = new Transaction(TransactionType.WITHDRAW, dateFormat.parse("07/10/2022"),
				new BigDecimal(100.0).negate());
		assertEquals(new BigDecimal(900.0), transaction.balanceAfterTransaction(new BigDecimal(1000.0)));
	}
}
