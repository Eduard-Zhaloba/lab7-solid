package variant1_orderfulfillment;

public interface EmailService {
    void sendOrderConfirmation(String email, String orderId);
}
