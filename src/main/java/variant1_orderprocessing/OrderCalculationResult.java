package variant1_orderprocessing;

import java.math.BigDecimal;

public class OrderCalculationResult {
    private final BigDecimal subtotal;
    private final BigDecimal discountAmount;
    private final BigDecimal taxAmount;
    private final BigDecimal totalAmount;

    public OrderCalculationResult(BigDecimal subtotal, BigDecimal discountAmount, BigDecimal taxAmount, BigDecimal totalAmount) {
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSubtotal() { return subtotal; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public BigDecimal getTaxAmount() { return taxAmount; }
    public BigDecimal getTotalAmount() { return totalAmount; }
}