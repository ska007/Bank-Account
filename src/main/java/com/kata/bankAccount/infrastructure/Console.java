package com.kata.bankAccount.infrastructure;

import com.kata.bankAccount.domain.IConsole;

public class Console implements IConsole {
	
	@Override
	public void printLine(String line) {
        System.out.println(line);
    }
}
