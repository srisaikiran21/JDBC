package com.user;

import java.util.Scanner;

import com.beans.Account;
import com.beans.Loan;
import com.beans.LoanType;
import com.beans.Transaction;
import com.service.IService;
import com.service.ServiceImpl;

public class Main {

	public static void main(String[] args) throws Exception{
Transaction account =null;
		
		IService service = null;
		
		service = new ServiceImpl();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		
			System.out.println("Choose any one");
			System.out.println("Enter 1 for Create account");
			System.out.println("Enter 2 for Deposit");
			System.out.println("Enter 3 for Withdraw");
			System.out.println("Enter 4 for ShowAccountDetails");
			System.out.println("Enter 5 for GetLoan");
			System.out.println("Enter 6 for PayLoan");
			System.out.println("Enter 7 for ShowLoanDetails");
			System.out.println("Enter 8 Exit");
			switch(sc.nextInt()) 
			{
		
			case 1 :
				account = new Transaction();
				while(true) {
				System.out.println("Enter account Id");
				String accountId = sc.next();
				if(service.accountIdValidation(accountId)) {	
					account.setAccountId(accountId);
					break;
					}
				else 
				{
						System.out.println("Invalid accountId format");
						return;
					}
				}		
				
				while(true) {
					System.out.println("Enter user name");
					String username = sc.next();
					if(service.accountNameValidation(username)) {
						account.setAccountName(username);
						break;
					}
					else 
					{
						System.out.println("Invalid name format");
						return;	
					}
				}	
				
				System.out.println("Enter address ");
				
				account.setAddress(sc.next());
				
				System.out.println("Enter deposit amount");
				account.setDepositAmount(sc.nextInt());
				
				System.out.println(" Applying Loans");
				System.out.println("1 for Yes \n "
						+ "2 for No :");
				int c = sc.nextInt();
				if(c==1) {
					System.out.println("Enter loanId");
					account.setLoanId(sc.nextInt());
					
					System.out.println("Enter loan Type \n Home\t Car \t  Education");
					System.out.println("Loan Type must be any of three");
					account.setLoanType(LoanType.valueOf(sc.next()));		
					
					System.out.println("Enter loan amount");
					account.setLoanAmount(sc.nextInt());
					
					
					
				}
				System.out.println("Account is created");
				service.createAccount(account);
				break;
				
				
	case 2:
				System.out.println("Enter accountId :");
				String accountId = sc.next();
				System.out.println("Enter amount :");
				int amount = sc.nextInt();
				int balance=service.depositAmount(accountId, amount);
				System.out.println("New balance :"+balance);
				break;
				
		case 3:
				System.out.println("Enter accountId ");
				String accountIdw = sc.next();
				System.out.println("Enter amount ");
				int amountw = sc.nextInt();
				int balanceWithdraw=service.withdrawAmount(accountIdw, amountw);
				System.out.println("New balance :"+balanceWithdraw);
				break;
				
		case 4:
				System.out.println("Enter AccountId ");
				String accnt = sc.next();
				Account acc = service.showAccountDetails(accnt);
				if(acc!=null) {
					System.out.println("Account Id : "+acc.getAccountId());
					System.out.println("Account Name : "+acc.getAccountName());
					System.out.println("Account holder address : "+acc.getAddress());
					System.out.println("Deposit Amount : "+acc.getDepositAmount());
					System.out.println();
					break;
				}
				else 
				{
					System.out.println("Not found");
					break;
				}
				
		case 5:
				System.out.println("Enter amount of loan: ");
				int loanamt = sc.nextInt();
				System.out.println("Enter loanId  ");
				int loanid = sc.nextInt();
				int loanbal = service.getLoan(loanid, loanamt);
				System.out.println(loanbal+" loan amount got");
				break;
		
		case 6:
				System.out.println("Enter amount ");
				int plamt = sc.nextInt();
				System.out.println("Enter loanId ");
				int payloanid = sc.nextInt();
				int payloanbal = service.payLoan(payloanid, plamt);
				System.out.println("paid loan amount "+payloanbal);
				break;
				
		case 7:
				System.out.println("Enter loanId : ");
				int loanId = sc.nextInt();
				Loan l = service.showLoanDetails(loanId);
				if(l!=null)
					System.out.println("Loan Id = "+l.getLoanId()+
							" Loan type = "+l.getLoanType()+" Loan Amount = "+l.getLoanAmount());
				else
					System.out.println("loanId not matched");
				
				break;
				
		case 8:
				System.out.println("Thank you");
				sc.close();
				break;
				
       	}
	
}
	}
}