package variant1_orderfulfillment;

public class MySqlDatabaseRepository implements OrderRepository {

    @Override
    public void saveOrder(Order order) {
        System.out.println(
                "[MySQL DB] Замовлення " + order.getOrderId()
                        + " на суму " + order.getTotalAmount()
                        + " грн збережено в таблицю 'orders'."
        );
    }
}
