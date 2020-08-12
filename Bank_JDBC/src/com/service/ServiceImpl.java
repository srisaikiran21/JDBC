package com.service;

import java.sql.SQLException;


import com.beans.Account;
import com.beans.Loan;
import com.dao.DaoImpl;



public class ServiceImpl implements IService{
	
   DaoImpl dao;
	
	public ServiceImpl() throws Exception {
		dao= new DaoImpl();
	}
	
	@Override
	public boolean accountIdValidation(String id) throws SQLException
	{
		String regId = "^[0-9]{7}-[A-Za-z]{4}$";
		return id.matches(regId);
		
	}
	
	@Override
	public boolean accountNameValidation(String name) throws SQLException
	{
		String regName = "^[A-Z]{1}[a-z]{2,}$";
		
		return name.matches(regName);
		
	}


	@Override
	public void createAccount(Account account) throws SQLException {
		dao.createAccount(account);
		
	}
	
	@Override
    public int depositAmount(String accountId, int amount) throws SQLException {
			// TODO Auto-generated method stub
			return dao.depositAmount(accountId, amount);
		
	}
	
	@Override
   public int withdrawAmount(String accountId, int amount) throws SQLException {
	// TODO Auto-generated method stub
	return dao.withdrawAmount(accountId, amount);
}


	@Override
	public Account showAccountDetails(String accNum) throws SQLException {
		return dao.showAccountDetails(accNum);
		
	}
	
	
	@Override
	public int getLoan(int loanId,int loanAmt) throws SQLException {
		return dao.getLoan(loanId, loanAmt);
	}
	
	
	@Override
	public Loan showLoanDetails(int loanId) throws SQLException {
		return dao.showLoanDetails(loanId);
	}
	
	@Override
	public int payLoan(int loanId, int loanAmt) throws SQLException {
		return dao.payLoan(loanId, loanAmt);
	}
}
