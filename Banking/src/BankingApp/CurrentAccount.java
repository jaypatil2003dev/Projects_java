package BankingApp;
import java.math.BigDecimal;

public class CurrentAccount extends Account{
	private static final BigDecimal OVERDRAFT_LIMIT =new BigDecimal("1000.00");

	public CurrentAccount(String accountNo, String holderName) {
		super(accountNo, holderName);
	}
	
	@Override
	public void withdraw(BigDecimal amount) throws Exception{
		if(amount.compareTo(BigDecimal.ZERO)<=0)
			throw new Exception("Withdrawal must be positive");
		if(balance.subtract(amount).compareTo(OVERDRAFT_LIMIT.negate())<=0)
			throw new Exception("Overdraft limit exceeded(1000)");
		balance = balance.subtract(amount);
	}

}
