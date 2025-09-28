package BankingApp;
import java.math.BigDecimal;

public class savingaccount extends Account{
	 private static final BigDecimal MIN_BALANCE = new BigDecimal("500.00");
	    private static final BigDecimal INTEREST_RATE = new BigDecimal("0.02"); // 2%

	    public savingaccount(String accountNo, String holderName) {
	        super(accountNo, holderName);

}

		@Override
		public void withdraw(BigDecimal amount) throws Exception {
			if(amount.compareTo(BigDecimal.ZERO)<=0)
				throw new Exception("Withdrawal must be positive");
			if(balance.subtract(amount).compareTo(MIN_BALANCE)<0)
				throw new Exception("Insufficent balance (min balance required: 500)");
			balance = balance.subtract(amount);
			
			
		}
		
		public void applyInterest() {
			BigDecimal interest = balance.multiply(INTEREST_RATE);
			balance= balance.add(interest);
		}
}
