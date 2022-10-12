package com.kata.bankAccount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.kata.bankAccount.format.StatementLineFormatter;
import com.kata.bankAccount.infrastructure.ConsoleStatementPrinter;

public class AccountTest {
	
	private Account account;
	IStatementPrinter statementPrinter;
	private IConsole console ;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

	@Before
	public void setUp() {
		final StatementLineFormatter statementLineFormatter = new StatementLineFormatter();
		console = mock(IConsole.class);
		statementPrinter = new ConsoleStatementPrinter(statementLineFormatter, console);
		account = new Account(statementPrinter);
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
	
	@Test
	public void should_withdraw_some_of_savings() throws ParseException {
		account.deposit(dateFormat.parse("09/10/2022"), new BigDecimal(100.0));
		account.withdraw(dateFormat.parse("10/10/2022"), new BigDecimal(50.0));
		assertEquals(new BigDecimal(50.0), account.getBalance());
	}
	
	@Test
	public void should_withdraw_all_savings() throws ParseException {
		account.deposit(dateFormat.parse("09/10/2022"), new BigDecimal(100.0));
		account.withdraw(dateFormat.parse("10/10/2022"), new BigDecimal(100.0));
		assertEquals(BigDecimal.ZERO, account.getBalance());
	}
	
	@Test
	public void should_not_withdraw_more_than_balance() throws ParseException {
		account.deposit(dateFormat.parse("09/10/2022"), new BigDecimal(70.0));
		assertThrows(IllegalArgumentException.class,
				() -> account.withdraw(dateFormat.parse("10/10/2022"), new BigDecimal(100.0)));
	}
	
	@Test
	public void should_print_account_transactions_history() throws ParseException {
		account.deposit(dateFormat.parse("07/10/2022"), new BigDecimal(50.0));
		account.withdraw(dateFormat.parse("08/10/2022"), new BigDecimal(50.0));
		account.deposit(dateFormat.parse("09/10/2022"), new BigDecimal(100.0));
			
		InOrder inOrder = Mockito.inOrder(console);
		account.printStatement();	
		
		inOrder.verify(console).printLine("DEPOSIT | 07/10/2022 | 50 | 50" + System.lineSeparator());
		inOrder.verify(console).printLine("WITHDRAW | 08/10/2022 | 50 | 0" + System.lineSeparator());
		inOrder.verify(console).printLine("DEPOSIT | 09/10/2022 | 100 | 100" + System.lineSeparator());
		
	}
}
