package variant1_orderprocessing;
import java.math.BigDecimal;
public abstract class BankAccount {
 protected String accountNumber;
 protected BigDecimal balance;

 public BankAccount(String accountNumber, BigDecimal initialBalance) {
     this.accountNumber = accountNumber;
     this.balance = initialBalance;
 }

 public String getAccountNumber() { return accountNumber; }
 public BigDecimal getBalance() { return balance; }

 public void deposit(BigDecimal amount) {
     if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
     balance = balance.add(amount);
 }
}