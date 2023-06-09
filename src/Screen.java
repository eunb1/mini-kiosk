import java.util.*;

public class Screen {
    private static int waitingNumber = 1;
    private Scanner scan = new Scanner(System.in);
    private Order order = new Order();
    private ArrayList<Menu> menuList;
    private HashMap<String, ArrayList<Product>> menuMap;

    public Screen(ArrayList<Menu> menuList, HashMap<String, ArrayList<Product>> menuMap) {
        this.menuList = menuList;
        this.menuMap = menuMap;
    }

    public void display() throws InterruptedException {
        while(true) {
            printMainMenu();
            int input = scan.nextInt();
            switch (input) {
                case 0 -> printTotalSales();
                case 1, 2, 3, 4 -> printProductMenu(input);
                case 5 -> proceedOrder();
                case 6 -> cancelOrder();
                default -> throw new BadInputException("잘못된 입력값: " + input);
            }
        }
    }

    private void printTotalSales() {
        System.out.println("[ 총 판매금액 현황 ]");
        System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n", order.getTotalSales());

        System.out.println("[ 총 판매상품 목록 현황 ]");
        System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
        for(Map.Entry<Product, Integer> entry : order.getSalesRecord().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%-20s | W %.1f | %d개\n", product.getName(), product.getPrice(), quantity);
        }
        System.out.println();
        System.out.println("1. 돌아가기");
        if(scan.nextInt() == 1) {
            return;
        }
    }

    private void cancelOrder() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인     2. 취소");

        if(scan.nextInt() == 1) {
            order.cancel();
        }
    }

    private void proceedOrder() throws InterruptedException {
        double totalAmount = 0.0;
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for(Map.Entry<Product, Integer> entry : order.getOrderMap().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalAmount += product.getPrice() * quantity;
            System.out.printf("%-20s | W %.1f | %d개 | %s\n", product.getName(), product.getPrice(), quantity, product.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("W %.1f", totalAmount);
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");

        if(scan.nextInt() == 1) {
            order.confirm(totalAmount, waitingNumber++);
        }
    }

    private void printProductMenu(int input) {
        String category = menuList.get(input - 1).getName();
        System.out.println("Mc Donald's 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.printf("[ %s MENU ]\n", category);
        ArrayList<Product> productList = menuMap.get(category);
        for(int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.printf("%d. %-20s | W %.1f | %s\n", i + 1, product.getName(), product.getPrice(), product.getDescription());
        }
        selectProductMenu(productList);
    }

    private void selectProductMenu(ArrayList<Product> productList){
        int input = scan.nextInt();
        if(input < 1 || input > productList.size()) {
            throw new BadInputException("잘못된 입력값: " + input);
        }
        Product product = productList.get(input - 1);
        System.out.printf("%-20s | W %.1f | %s\n", product.getName(), product.getPrice(), product.getDescription());

        if(product.hasOptions()) {
            product = selectOption(product);
        }

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인     2. 취소");

        if(scan.nextInt() == 1) {
            order.add(product);
        }
    }

    private Product selectOption(Product product) {
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        List<Option> options = product.getOptions();
        for(int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            System.out.printf("%d. %s(W %.1f)\t", (i + 1), option.getTag(), option.getPrice());
        }
        System.out.println();
        int input = scan.nextInt();
        if(input < 1 || input > options.size()) {
            throw new BadInputException("잘못된 입력값: " + input);
        }
        Product option = options.get(input - 1);
        System.out.printf("%-20s | W %.1f | %s\n", option.getName(), option.getPrice(), option.getDescription());
        return option;
    }

    private void printMainMenu() {
        System.out.println("Mc Donald's 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println("[ MC DONALD'S MENU ]");
        for(int i = 0; i < menuList.size(); i++) {
            Menu menu = menuList.get(i);
            System.out.printf("%d. %-15s | %s\n", i + 1, menu.getName(), menu.getDescription());
        }

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order         | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel        | 진행중인 주문을 취소합니다.");
    }
}
