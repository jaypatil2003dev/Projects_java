package BankingApp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
	private static int counter =1;
	
	private int id;
	private String accountNo;
	private String type; //deposit, withdraw, transfer
	private BigDecimal amount;
	private LocalDateTime timestamp;
	private String note;
	
	public Transaction(String accountNo, String type, BigDecimal amount, String note) {
		super();
		this.id = counter++;
		this.accountNo = accountNo;
		this.type = type;
		this.amount = amount;
		this.timestamp = LocalDateTime.now();
		this.note = note;
	}
	
	@Override
	public String toString() {
		return String.format("[%d] %s | %s |%s |%s",id,timestamp,accountNo,type,amount);
	}
	
	
    }

