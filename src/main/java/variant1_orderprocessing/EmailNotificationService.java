package variant1_orderprocessing;

public class EmailNotificationService {
    public void sendInvoiceEmail(String customerEmail, String htmlContent) {
        try {
            System.out.println("Надсилання email на " + customerEmail + " через smtp.store.local:587");
            System.out.println("Тема: Ваше замовлення успішно оформлено");
            System.out.println("Тіло: " + htmlContent);
        } catch (Exception ex) {
            System.out.println("Помилка відправки email: " + ex.getMessage());
        }
    }
}