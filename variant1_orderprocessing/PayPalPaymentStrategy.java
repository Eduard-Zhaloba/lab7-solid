package variant1_orderprocessing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.034"))
                     .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void process(PaymentRequest request) {
        BigDecimal fee = calculateFee(request.getAmount());
        System.out.println("[PayPal] Перенаправлення на шлюз PayPal для " + request.getPayerId() + ". Комісія системи: $" + fee);
    }
}