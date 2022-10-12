package com.kata.bankAccount.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AccountTest {

	@Test
	public void should_deposit_amount() {
		Account account = new Account();
		account.deposit("10/10/2022", new BigDecimal(100.0));
		assertEquals(new BigDecimal(100.0), account.getBalance());
	}
}
