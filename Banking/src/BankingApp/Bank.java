package BankingApp;

import java.math.BigDecimal;
import java.util.*;


public class Bank {
	private Map<String, Account> accounts= new HashMap<>();
	private List<Transaction> transactions = new ArrayList<>();
	
	public void createSavingsAccount(String accNo, String name) {
		accounts.put(accNo,new savingaccount(accNo, name) );
	}
	
	public void createCurrentAccount(String accNo, String name) {
		accounts.put(accNo,new CurrentAccount(accNo, name) );
	}
	
	public Account getAccount(String accNo) {
		return accounts.get(accNo);
	}
	
	public void deposit(String accNo, BigDecimal amount) throws Exception{
		Account acc = getAccount(accNo);
		acc.deposit(amount);
		transactions.add(new Transaction(accNo,"Deposit",amount, "Deposited"));
	}
	
	public void withdraw(String accNo, BigDecimal amount) throws Exception{
		Account acc = getAccount(accNo);
		acc.withdraw(amount);
		transactions.add(new Transaction(accNo,"Withdraw",amount, "Withdrawn"));

		
}
	public void transfer(String fromAcc, String toAcc, BigDecimal amount) throws Exception {
        Account acc1 = getAccount(fromAcc);
        Account acc2 = getAccount(toAcc);
        acc1.withdraw(amount);
        acc2.deposit(amount);
        transactions.add(new Transaction(fromAcc, "Transfer", amount.negate(), "To " + toAcc));
        transactions.add(new Transaction(toAcc, "Transfer", amount, "From " + fromAcc));
    }

    public void printMiniStatement(String accNo) {
        transactions.stream()
            .filter(t -> t.toString().contains(accNo))
            .forEach(System.out::println);
    }

    public void applyInterestToSavings() {
        for (Account acc : accounts.values()) {
            if (acc instanceof savingaccount) {
                ((savingaccount) acc).applyInterest();
            }
        }
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }
}
