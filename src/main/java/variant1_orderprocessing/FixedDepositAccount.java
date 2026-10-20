package variant1_orderprocessing;
import java.math.BigDecimal;
public class FixedDepositAccount extends BankAccount {
 private int termMonths;

 public FixedDepositAccount(String accountNumber, BigDecimal initialBalance, int termMonths) {
     super(accountNumber, initialBalance);
     this.termMonths = termMonths;
 }

 public int getTermMonths() { return termMonths; }
 
}