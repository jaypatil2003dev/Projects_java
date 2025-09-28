package BankingApp;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Account {
	protected String accountNo;
	protected String holderName;
	protected BigDecimal balance;
	protected LocalDate openedOn;
	protected boolean active;
	public Account(String accountNo, String holderName) {
		super();
		this.accountNo = accountNo;
		this.holderName = holderName;
		this.balance = BigDecimal.ZERO;
		this.openedOn = LocalDate.now();
		this.active = true;
	}
	
	public abstract void withdraw(BigDecimal amount) throws Exception;
	
	public void deposit(BigDecimal amount)throws Exception{
		if(amount.compareTo(BigDecimal.ZERO)<=0)
			throw new Exception("Deposit must be positive");
		balance = balance.add(amount);
	}
	
	public String getAccountNo() {return accountNo;}
	public String getHolderName() {return holderName;}
	public BigDecimal getBalance() {return balance;}
	public boolean isActive() {return active;}
	
	@Override
	public String toString() {
		return String.format("%s - %s (Balance: %s", accountNo, holderName,balance);
	}
	

}
