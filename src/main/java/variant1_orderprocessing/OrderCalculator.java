package variant1_orderprocessing;

import java.math.BigDecimal;
import java.util.List;

public class OrderCalculator {
    public OrderCalculationResult calculate(List<OrderItem> items, String customerCategory) {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (OrderItem item : items) {
            BigDecimal itemTotal = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            subtotal = subtotal.add(itemTotal);
        }

        BigDecimal discountRate = BigDecimal.ZERO;
        if ("VIP".equalsIgnoreCase(customerCategory)) {
            discountRate = new BigDecimal("0.15");
        } else if ("Regular".equalsIgnoreCase(customerCategory)) {
            discountRate = new BigDecimal("0.05");
        }

        BigDecimal discountAmount = subtotal.multiply(discountRate);
        BigDecimal taxableSubtotal = subtotal.subtract(discountAmount);
        BigDecimal taxAmount = taxableSubtotal.multiply(new BigDecimal("0.20")); 
        BigDecimal totalAmount = taxableSubtotal.add(taxAmount);

        return new OrderCalculationResult(subtotal, discountAmount, taxAmount, totalAmount);
    }
}