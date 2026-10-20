package variant1_orderprocessing;
import java.math.BigDecimal;
public class StandardBankAccount extends BankAccount implements Withdrawable {
 public StandardBankAccount(String accountNumber, BigDecimal initialBalance) {
     super(accountNumber, initialBalance);
 }

 @Override
 public void withdraw(BigDecimal amount) {
     if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Amount must be positive");
     if (amount.compareTo(balance) > 0) throw new IllegalStateException("Insufficient funds");
     balance = balance.subtract(amount);
 }
}