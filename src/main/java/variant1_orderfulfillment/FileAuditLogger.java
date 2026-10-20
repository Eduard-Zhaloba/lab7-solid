package variant1_orderfulfillment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileAuditLogger implements AuditLogger {

    @Override
    public void logTransaction(String message) {
        String time = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        System.out.println(
                "[File Logger] Запис до файлу audit.log: "
                        + time + " - " + message
        );
    }
}
