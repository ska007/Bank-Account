package com.kata.bankAccount.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private String type;
	private Date date;
	private BigDecimal amount;

	public Transaction(String type, Date date, BigDecimal amount) {
		this.type = type;
		this.date = date;
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getAmount() {
		return amount;
	}
}
