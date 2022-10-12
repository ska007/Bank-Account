package com.kata.bankAccount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	
	@Before
	public void setUp() {
		account = new Account();
	}

	@Test
	public void should_deposit_amount() throws ParseException {
		account.deposit(dateFormat.parse("10/10/2022"), new BigDecimal(100.0));
		assertEquals(new BigDecimal(100.0), account.getBalance());
	}
	
	@Test
	public void should_not_deposit_negative_amount() {
		assertThrows(IllegalArgumentException.class, 
				() -> account.deposit(dateFormat.parse("10/10/2022"), new BigDecimal(-50.0)));
	}
}
