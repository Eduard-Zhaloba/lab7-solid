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
        /////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("=== Тестування OCP та Патерну 'Стратегія' ===");

        PaymentRequest request = new PaymentRequest(
            "TXN-9999", 
            new BigDecimal("200.00"), 
            "USD", 
            "customer_alex"
        );

        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("\n--- Тест 1: Credit Card ---");
        PaymentStrategy creditCardStrategy = new CreditCardPaymentStrategy();
        processor.processPayment(request, creditCardStrategy);

        System.out.println("\n--- Тест 2: PayPal ---");
        PaymentStrategy paypalStrategy = new PayPalPaymentStrategy();
        processor.processPayment(request, paypalStrategy);

        System.out.println("\n--- Тест 3: Crypto ---");
        PaymentStrategy cryptoStrategy = new CryptoPaymentStrategy();
        processor.processPayment(request, cryptoStrategy);
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(" ");
        System.out.println("\n=== Тестування Завдання 3 (Виправлення LSP через інтерфейси) ===");

        StandardBankAccount regularAccount = new StandardBankAccount("ACC-101", new BigDecimal("1000.00"));
        FixedDepositAccount depositAccount = new FixedDepositAccount("ACC-202", new BigDecimal("5000.00"), 12);

        BankService bankService = new BankService();

      
        System.out.println("\n--- Тест 1: Звичайний рахунок ---");
        System.out.println("Початковий баланс: $" + regularAccount.getBalance());
        
       
        regularAccount.deposit(new BigDecimal("200.00"));
        System.out.println("Після поповнення: $" + regularAccount.getBalance());

       
        bankService.processMonthlyFee(regularAccount, new BigDecimal("50.00"));


       
        System.out.println("\n--- Тест 2: Депозитний рахунок ---");
        System.out.println("Номер депозиту: " + depositAccount.getAccountNumber());
        System.out.println("Сума на депозиті: $" + depositAccount.getBalance());
        System.out.println("Термін: " + depositAccount.getTermMonths() + " місяців");
        System.out.println("\nКомісія з депозиту не може бути знята помилково — компілятор захищає код!");
    }
}