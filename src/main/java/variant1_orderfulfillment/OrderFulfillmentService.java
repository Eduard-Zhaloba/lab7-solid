package variant1_orderfulfillment;

import java.util.Objects;

public class OrderFulfillmentService {

    private final OrderRepository databaseRepository;
    private final EmailService emailService;
    private final AuditLogger fileLogger;

    public OrderFulfillmentService(
            OrderRepository databaseRepository,
            EmailService emailService,
            AuditLogger fileLogger) {

        this.databaseRepository = Objects.requireNonNull(
                databaseRepository, "OrderRepository cannot be null"
        );

        this.emailService = Objects.requireNonNull(
                emailService, "EmailService cannot be null"
        );

        this.fileLogger = Objects.requireNonNull(
                fileLogger, "AuditLogger cannot be null"
        );
    }

    public void processOrder(Order order) {
        if (order == null || order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Замовлення не може бути порожнім.");
        }

        this.databaseRepository.saveOrder(order);

        this.fileLogger.logTransaction(
                "Успішно оброблено замовлення " + order.getOrderId()
        );

        this.emailService.sendOrderConfirmation(
                order.getCustomerEmail(),
                order.getOrderId()
        );
    }
}
