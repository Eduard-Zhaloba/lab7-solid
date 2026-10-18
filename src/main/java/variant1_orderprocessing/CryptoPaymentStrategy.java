package variant1_orderprocessing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CryptoPaymentStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        BigDecimal fee = amount.multiply(new BigDecimal("0.008")).setScale(2, RoundingMode.HALF_UP);
        if (fee.compareTo(new BigDecimal("1.00")) < 0) {
            return new BigDecimal("1.00");
        }
        if (fee.compareTo(new BigDecimal("20.00")) > 0) {
            return new BigDecimal("20.00");
        }
        return fee;
    }

    @Override
    public void process(PaymentRequest request) {
        System.out.println("[Crypto] Очікування підтвердження транзакції в мережі Blockchain для " + request.getPayerId() + ".");
    }
}