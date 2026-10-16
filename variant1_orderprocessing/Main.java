package variant1_orderprocessing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Запуск обробки замовлення...");

        
        List<OrderItem> items = new ArrayList<>();
        
        OrderItem item1 = new OrderItem();
        item1.setItemId("A1");
        item1.setName("Смартфон");
        item1.setPrice(new BigDecimal("15000.00"));
        item1.setQuantity(1);
        items.add(item1);

        OrderPlacementService orderService = new OrderPlacementService();

        try {
            orderService.processOrder(
                "customer@example.com", 
                "VIP", 
                items, 
                "м. Київ, вул. Головна, 10"
            );
            System.out.println("Замовлення успішно оформлено та збережено!");
        } catch (Exception e) {
            System.err.println("Помилка під час оформлення замовлення: " + e.getMessage());
        }
    }
}