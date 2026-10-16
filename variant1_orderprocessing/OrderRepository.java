package variant1_orderprocessing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderRepository {
    public void save(String customerEmail, BigDecimal totalAmount, String deliveryAddress) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String record = String.format("%s|%s|%s|%s%n", timestamp, customerEmail, totalAmount, deliveryAddress);
        try (FileWriter fw = new FileWriter("orders_db.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.print(record);
        } catch (IOException e) {
            System.err.println("Помилка запису у файл бази даних: " + e.getMessage());
        }
    }
}