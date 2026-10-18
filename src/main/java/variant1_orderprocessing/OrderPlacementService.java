package variant1_orderprocessing;

import java.util.List;

public class OrderPlacementService {
    private final OrderValidator validator = new OrderValidator();
    private final OrderCalculator calculator = new OrderCalculator();
    private final InvoiceHtmlFormatter formatter = new InvoiceHtmlFormatter();
    private final OrderRepository repository = new OrderRepository();
    private final EmailNotificationService notificationService = new EmailNotificationService();

    public void processOrder(String customerEmail, String customerCategory, List<OrderItem> items, String deliveryAddress) {
        validator.validate(customerEmail, items);
        OrderCalculationResult calculationResult = calculator.calculate(items, customerCategory);
        String htmlInvoice = formatter.format(customerEmail, deliveryAddress, items,customerCategory, calculationResult);

        repository.save(customerEmail, calculationResult.getTotalAmount(), deliveryAddress);

        notificationService.sendInvoiceEmail(customerEmail, htmlInvoice);
    }
}