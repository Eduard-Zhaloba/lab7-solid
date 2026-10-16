package variant1_orderprocessing;

import java.math.BigDecimal;

public interface PaymentStrategy {
    BigDecimal calculateFee(BigDecimal amount);
    void process(PaymentRequest request);
}