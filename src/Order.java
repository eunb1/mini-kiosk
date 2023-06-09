import java.util.HashMap;
import java.util.Map;

public class Order {
    private double totalSales = 0.0;
    private final Map<Product, Integer> orderMap = new HashMap<>();
    private final Map<Product, Integer> salesRecord = new HashMap<>();

    public Map<Product, Integer> getOrderMap() {
        return orderMap;
    }

    public Map<Product, Integer> getSalesRecord() {
        return salesRecord;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void add(Product product) {
        orderMap.put(product, orderMap.getOrDefault(product, 0) + 1);
        System.out.println(product.getName() + " 가 장바구니에 추가되었습니다.\n");
    }

    public void cancel() {
        orderMap.clear();
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    public void confirm(double totalAmount, int waitingNumber) throws InterruptedException {
        totalSales += totalAmount;
        for(Map.Entry<Product, Integer> entry : orderMap.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            salesRecord.put(product, salesRecord.getOrDefault(product, 0) + quantity);
        }
        orderMap.clear();
        System.out.println("주문이 완료되었습니다!\n");
        System.out.printf("대기 번호는 [ %d ] 번 입니다.\n", waitingNumber);
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)\n");
        Thread.sleep(3000);
    }
}
