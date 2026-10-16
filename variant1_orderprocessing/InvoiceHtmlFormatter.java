package variant1_orderprocessing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class InvoiceHtmlFormatter {
    public String format(String customerEmail, String deliveryAddress, List<OrderItem> items, String customerCategory, OrderCalculationResult calculationResult) {
        BigDecimal subtotal = calculationResult.getSubtotal();
        BigDecimal totalAmount = calculationResult.getTotalAmount();
        BigDecimal discountAmount = calculationResult.getDiscountAmount();
        BigDecimal taxAmount = calculationResult.getTaxAmount();
        StringBuilder htmlInvoice = new StringBuilder("<html><body>");
        htmlInvoice.append("<h1>Рахунок на замовлення для ").append(customerEmail).append("</h1>");
        htmlInvoice.append("<p>Адреса доставки: ").append(deliveryAddress).append("</p>");
        htmlInvoice.append("<table border='1'><tr><th>Товар</th><th>Кількість</th><th>Ціна</th></tr>");

        for (OrderItem item : items) {
            htmlInvoice.append("<tr><td>").append(item.getName())
                       .append("</td><td>").append(item.getQuantity())
                       .append("</td><td>").append(item.getPrice()).append(" грн</td></tr>");
        }

        htmlInvoice.append("</table>");
        htmlInvoice.append("<p>Проміжна сума: ").append(subtotal).append(" грн</p>");
        htmlInvoice.append("<p>Знижка (").append(customerCategory).append("): -").append(discountAmount).append(" грн</p>");
        htmlInvoice.append("<p>ПДВ (20%): ").append(taxAmount).append(" грн</p>");
        htmlInvoice.append("<h3>Загалом до сплати: ").append(totalAmount.setScale(2, RoundingMode.HALF_UP)).append(" грн</h3>");
        htmlInvoice.append("</body></html>");

        return htmlInvoice.toString();
    }
}