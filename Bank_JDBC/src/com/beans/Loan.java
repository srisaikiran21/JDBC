package com.beans;

public class Loan extends Account {

	private int LoanId;
	private LoanType LoanType;
	private int LoanAmount;
	
	
	public void showLoanDetails()
	{
		System.out.println("Loan Id = "+getLoanId());
		System.out.println("Loan amount = "+getLoanAmount());
		System.out.println("Loan Type = "+getLoanType());
	}


	


	public LoanType getLoanType() {
		return LoanType;
	}


	public void setLoanType(LoanType loanType) {
		LoanType = loanType;
	}





	public int getLoanId() {
		return LoanId;
	}

	public void setLoanId(int loanId) {
		LoanId = loanId;
	}




	public int getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		LoanAmount = loanAmount;
	}


	
	
	
}
