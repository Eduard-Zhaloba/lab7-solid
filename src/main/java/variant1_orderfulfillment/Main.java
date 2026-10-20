package variant1_orderfulfillment;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Order order = new Order();
        order.setOrderId("ORD-001");
        order.setCustomerEmail("customer@example.com");
        order.setTotalAmount(2500.00);
        order.setItems(new ArrayList<>(
                List.of("Laptop", "Mouse")
        ));

        // Production configuration
        OrderRepository productionRepository =
                new MySqlDatabaseRepository();

        EmailService emailService = new SmtpEmailService();
        AuditLogger auditLogger = new FileAuditLogger();

        OrderFulfillmentService productionService =
                new OrderFulfillmentService(
                        productionRepository,
                        emailService,
                        auditLogger
                );

        System.out.println("=== PRODUCTION MODE ===");
        productionService.processOrder(order);

        // Mock configuration
        OrderRepository mockRepository =
                new MockOrderRepository();

        OrderFulfillmentService mockService =
                new OrderFulfillmentService(
                        mockRepository,
                        emailService,
                        auditLogger
                );

        System.out.println("\n=== MOCK MODE ===");
        mockService.processOrder(order);
    }
}
