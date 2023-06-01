import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> orderList = new ArrayList<>();

    public List<Product> getOrderList() {
        return orderList;
    }

    public void add(Product product) {
        orderList.add(product);
        System.out.println(product.getName() + " 가 장바구니에 추가되었습니다.\n");
    }

    public void cancel() {
        orderList.clear();
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    public void confirm(int waitingNumber) throws InterruptedException {
        orderList.clear();
        System.out.println("주문이 완료되었습니다!\n");
        System.out.printf("대기 번호는 [ %d ] 번 입니다.\n", waitingNumber);
        System.out.println("(3초 후 메뉴판으로 돌아갑니다.)\n");
        Thread.sleep(3000);
    }
}
