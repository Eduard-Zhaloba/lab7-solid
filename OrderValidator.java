package variant1_orderprocessing;

import java.util.List;

public class OrderValidator {
    public void validate(String customerEmail, List<OrderItem> items) {
        if (customerEmail == null || customerEmail.isBlank() || !customerEmail.contains("@")) {
            throw new IllegalArgumentException("Некоректна електронна адреса покупця.");
        }

        if (items == null || items.isEmpty()) {
            throw new IllegalStateException("Кошик порожній.");
        }

        for (OrderItem item : items) {
            if (item.getQuantity() <= 0 || item.getPrice() == null || item.getPrice().compareTo(java.math.BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Некоректний товар " + item.getName() + ": ціна та кількість мають бути більше 0.");
            }
        }
    }
}