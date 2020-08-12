package com.dao;

import java.sql.SQLException;

import com.beans.Account;
import com.beans.Loan;

public interface IDao {

	public int depositAmount(String accountId, int amount) throws SQLException;
	public int withdrawAmount(String accountId, int amount) throws SQLException;
	
	public Account showAccountDetails(String accNum) throws SQLException;
	
	public void createAccount(Account account) throws SQLException;
	
	public int getLoan(int loanId, int lamt) throws SQLException;
	
	public Loan showLoanDetails(int loanId) throws SQLException;
	public int payLoan(int loanId, int loanAmt) throws SQLException;
}
