package com.service;

import java.sql.SQLException;

import com.beans.Account;
import com.beans.Loan;

public interface IService {
	
	public boolean accountIdValidation(String id) throws SQLException;
	public boolean accountNameValidation(String name) throws SQLException;
	
	
	public void createAccount(Account account) throws SQLException;
	public int depositAmount(String accountId, int amount) throws SQLException;
	public int withdrawAmount(String accountId, int amount) throws SQLException;
	public Account showAccountDetails(String accNum) throws SQLException;
	public int getLoan(int loanId,int loanAmt) throws SQLException;
	public Loan showLoanDetails(int loanId) throws SQLException;
	public int payLoan(int loanId, int loanAmt) throws SQLException;
}
