package variant1_orderprocessing;

import java.math.BigDecimal;

public class BankTransferPaymentStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return new BigDecimal("5.00");
    }

    @Override
    public void process(PaymentRequest request) {
        BigDecimal fee = calculateFee(request.getAmount());
        BigDecimal totalAmount = request.getAmount().add(fee);
        System.out.println("[BankTransfer] Формування платіжного доручення SWIFT/IBAN для " + request.getPayerId() + ". Сума: $" + totalAmount);
    }
}