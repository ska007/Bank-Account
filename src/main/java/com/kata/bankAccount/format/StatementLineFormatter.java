package com.kata.bankAccount.format;

import java.text.SimpleDateFormat;

import com.kata.bankAccount.domain.StatementLine;


public class StatementLineFormatter {
	
	private static final String FIELD_SEPARATOR = " | ";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

	public String format(final StatementLine statementLine) {
		return statementLine.type() + FIELD_SEPARATOR + dateFormat.format(statementLine.date()) + FIELD_SEPARATOR
				+ statementLine.amount().abs() + FIELD_SEPARATOR + statementLine.balance() + System.lineSeparator();
	}

}
