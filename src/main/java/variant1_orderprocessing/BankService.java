package variant1_orderprocessing;
import java.math.BigDecimal;
public class BankService {
 public void processMonthlyFee(StandardBankAccount account, BigDecimal fee) {
     account.withdraw(fee);
     System.out.println("Fee processed for " + account.getAccountNumber() + ". New balance: " + account.getBalance());
 }
}