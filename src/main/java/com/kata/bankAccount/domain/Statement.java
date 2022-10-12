package com.kata.bankAccount.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Statement implements Iterable<StatementLine> {

	private List<StatementLine> statementLines = new ArrayList<>();

	public void addLine(StatementLine statementLine) {
		statementLines.add(statementLine);
	}

	@Override
	public Iterator<StatementLine> iterator() {
		return this.statementLines.iterator();
	}

	public boolean contains(StatementLine statementLine) {
		return statementLines.contains(statementLine);
	}
}
