package variant1_orderprocessing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.025"))
                     .add(new BigDecimal("0.30"))
                     .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void process(PaymentRequest request) {
        BigDecimal fee = calculateFee(request.getAmount());
        BigDecimal totalAmount = request.getAmount().add(fee);
        System.out.println("[CreditCard] Авторизація картки для користувача " + request.getPayerId() + ". Списано: $" + totalAmount);
    }
}