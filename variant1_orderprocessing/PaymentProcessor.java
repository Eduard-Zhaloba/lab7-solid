package variant1_orderprocessing;

public class PaymentProcessor {
    public void processPayment(PaymentRequest request, PaymentStrategy strategy) {
        System.out.println("[LOG] Початок обробки транзакції " + request.getTransactionId() + " на суму " + request.getAmount() + " " + request.getCurrency());

        strategy.process(request);
    }
}