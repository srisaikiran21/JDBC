package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.beans.Account;
import com.beans.Loan;
import com.beans.LoanType;
import com.beans.Transaction;



public class DaoImpl implements IDao{

	int amount=0;
	
	/*String url="jdbc:mysql://localhost:3306/bank";
	String username="root";
	String password="kiran";*/
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","kiran");
	
	public DaoImpl() throws Exception {
		
		
	}
	
	@Override
	public int depositAmount(String accountId, int amount) throws SQLException 
	{
	     String getAmount = "select depositAmount from account_1 where accountId = ?";
	     
		PreparedStatement p = con.prepareStatement(getAmount);
		
		p.setString(1, accountId);
		ResultSet rset = p.executeQuery();
		rset.next();
		
		int amt1 = rset.getInt(1)+amount;
		
		String depoUpdate = "update account_1 set depositAmount = ? where accountId = ?";
		
		PreparedStatement p1 = con.prepareStatement(depoUpdate);
		
		p1.setInt(1, amt1);
		p1.setString(2, accountId);
		p1.executeUpdate();
		
		
		return amt1;
	}
	
	@Override
	public int withdrawAmount(String accountId, int amount) throws SQLException 
	{
	
		String getAmount = "select depositAmount from account_1 where accountId = ?";
		PreparedStatement p = con.prepareStatement(getAmount);
		
		p.setString(1, accountId);
		ResultSet rset = p.executeQuery();
		rset.next();
		
		int amt = rset.getInt(1)-amount;
		
		String depoUpdate = "update account set depositAmount = ? where accountId = ?";
		PreparedStatement p1 = con.prepareStatement(depoUpdate);
		
		p1.setInt(1, amt);
		p1.setString(2, accountId);
		p1.executeUpdate();
		
	return amt;
	}

	@Override
	public Account showAccountDetails(String accNum) throws SQLException 
	{
		
		String getAccDetails = "select accountId,accountName,address,depositAmount from account where accountId = ?";
		
		PreparedStatement p = con.prepareStatement(getAccDetails);
		
		p.setString(1, accNum);
		ResultSet rset = p.executeQuery();
		rset.next();
		
		Account account =new Account();
		
		account.setAccountId(rset.getString(1));
		
		account.setAccountName(rset.getString(2));
		
		account.setAddress(rset.getString(3));
		account.setDepositAmount(rset.getDouble(4));
		
		return account;
	}
	
@Override
	public void createAccount(Account account) throws SQLException
{

		Transaction tr = (Transaction) account;
		String insertSql = "insert into Account_1 "+
							"(accountId,accountName,address,depositAmount,loanID,loanAmount,loanType)"+
				             "values(?,?,?,?,?,?,?)";
																																				
		
		PreparedStatement p = con.prepareStatement(insertSql);
		
		p.setString(1, tr.getAccountId());
		
		p.setString(2, tr.getAccountName());
		p.setString(3, tr.getAddress());
		p.setDouble(4, tr.getDepositAmount());
		p.setInt(5, tr.getLoanId());
		p.setInt(6, tr.getLoanAmount());
		
		p.setString(7, String.valueOf(tr.getLoanType()));
		
		
		int b = p.executeUpdate();
		System.out.println(b+" rows affected ");
	}
	
	public int getLoan(int loanId, int loanAmt) throws SQLException {
		
		int loanBalance=0;
		String getLoan = "select loanAmount from account_1 where loanID = ?";
		PreparedStatement p = con.prepareStatement(getLoan);
		p.setInt(1, loanId);
		ResultSet rset = p.executeQuery();
		rset.next();
		loanBalance = rset.getInt(1);
		loanBalance += loanAmt;
		
		String updateLoan = "update account_1 set loanAmount = ? where loanID = ?";
		PreparedStatement p1 = con.prepareStatement(updateLoan);
		p1.setInt(1, loanBalance);
		p1.setInt(2, loanId);
		p1.executeUpdate();
		
		return loanBalance;
	}

	@Override
	public Loan showLoanDetails(int loanId) throws SQLException {
		
		PreparedStatement p = con.prepareStatement("select loanID,loanAmount,loanType from account_1 where loanID = ?");
		
		p.setInt(1, loanId);
		ResultSet rset = p.executeQuery();
		rset.next();
		
		Loan loan = new Loan();
		loan.setLoanId(rset.getInt(1));
		loan.setLoanAmount(rset.getInt(2));
		loan.setLoanType(LoanType.valueOf(rset.getString(3)));
		
		return loan;
				
	}
	
	
	@Override
	public int payLoan(int loanId, int loanAmt) throws SQLException {
		
		int loanBalance = 0;
		

		String getLoan = "select loanAmount from account_01 where loanID = ?";
		PreparedStatement p = con.prepareStatement(getLoan);
		p.setInt(1, loanId);
		ResultSet rset = p.executeQuery();
		rset.next();
		loanBalance = rset.getInt(1);
		loanBalance -= loanAmt;
		
		String updateLoan = "update account_01 set loanAmount = ? where loanID = ?";
		PreparedStatement p1 = con.prepareStatement(updateLoan);
		p1.setInt(1, loanBalance);
		p1.setInt(2, loanId);
		p1.executeUpdate();
		
		return loanBalance;
	}

	}
	


	
	
	
	
	
	
	


