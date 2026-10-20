package variant1_orderfulfillment;

public class MockOrderRepository implements OrderRepository {

    @Override
    public void saveOrder(Order order) {
        System.out.println(
                "[MOCK DB] Тестове збереження замовлення "
                        + order.getOrderId()
                        + " на суму " + order.getTotalAmount()
                        + " грн."
        );
    }
}
