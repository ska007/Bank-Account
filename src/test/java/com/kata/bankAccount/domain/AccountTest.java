package com.kata.bankAccount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.Test;

public class AccountTest {

	@Test
	public void should_deposit_amount() {
		Account account = new Account();
		account.deposit("10/10/2022", new BigDecimal(100.0));
		assertEquals(new BigDecimal(100.0), account.getBalance());
	}
	
	@Test
	public void should_not_deposit_negative_amount() {
		Account account = new Account();
		assertThrows(IllegalArgumentException.class, 
				() -> account.deposit("10/10/2022", new BigDecimal(-50.0)));
	}
}
