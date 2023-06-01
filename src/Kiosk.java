import java.util.ArrayList;
import java.util.HashMap;

public class Kiosk {
    private Screen screen;
    private ArrayList<Menu> menuList = new ArrayList<>();
    private HashMap<String, ArrayList<Product>> menuMap = new HashMap<>();

    public void init() {
        menuList.add(new Menu("Burgers", "주문 즉시 바로 조리해 맛있는 맥도날드 버거"));
        menuList.add(new Menu ("Sides", "가볍게 즐겨도, 버거와 푸짐하게 즐겨도 언제나 맛있는 사이드 메뉴"));
        menuList.add(new Menu("Desserts", "여름을 더욱 시원하게 보낼 수 있는 디저트 메뉴"));
        menuList.add(new Menu("Beverages", "부담없는 가격으로 즐기는 다양한 음료"));

        ArrayList<Product> burgerList = new ArrayList<>();
        burgerList.add(new Product("Big Mac", 5.2, "50년 넘게 전 세계인의 입맛을 사로 잡은 버거"));
        burgerList.add(new Product("Quarter Pounder", 5.5, "1/4파운드 비프와 치즈 두 장이 들어간 버거"));
        burgerList.add(new Product("Shanghai Burger", 5.2, "매콤한 시즈닝을 입힌 100% 닭가슴 통살 버거"));
        burgerList.add(new Product("Bulgogi Burger", 2.3, "한국인 입맛에 딱 맛는 불고기 소스가 들어간 버거"));

        // 치즈 버거 메뉴에만 세 가지 옵션 추가
        ArrayList<Option> cheeseburgerOptions = new ArrayList<>();
        cheeseburgerOptions.add(new Option("Single", "Cheeseburger(Single)", 2.7, "순 쇠고기 패티 한 장"));
        cheeseburgerOptions.add(new Option("Double", "Cheeseburger(Double)", 4.7, "순 쇠고기 패티 무려 두 장"));
        cheeseburgerOptions.add(new Option("Triple", "Cheeseburger(Triple)", 5.8, "순 쇠고기 패티 놀랍게도 세 장"));
        burgerList.add(new Product("Cheeseburger", 4.7, "100% 순 쇠고기 패티와 치즈가 함께한 버거", cheeseburgerOptions));
        menuMap.put("Burgers", burgerList);

        ArrayList<Product> sideList = new ArrayList<>();
        sideList.add(new Product("McWings", 3.2, "겉은 바삭하고 속은 쫄깃한 치킨 윙"));
        sideList.add(new Product("McNuggets", 2.5, "바삭하고 촉촉한 치킨을 한 입에 쏙 즐기는 너겟"));
        sideList.add(new Product("French Fries", 1.3, "맥도날드의 역사가 담긴 월드 클래스 후렌치 후라이"));
        sideList.add(new Product("Chicken Snack Wrap", 2.7, "매콤한 치킨에 화이트 마요 소스가 어우러진 스낵 랩"));
        menuMap.put("Sides", sideList);

        ArrayList<Product> dessertList = new ArrayList<>();
        dessertList.add(new Product("McFlurry", 3.0, "맥도날드의 대표적인 아이스크림 디저트"));
        dessertList.add(new Product("Ice Cream Cone", 1.1, "신선한 우유로 만든 아이스크림 콘"));
        dessertList.add(new Product("Sundae", 2.1, "달콤한 토핑을 얹은 부드러운 아이스크림"));
        menuMap.put("Desserts", dessertList);

        ArrayList<Product> beverageList = new ArrayList<>();
        beverageList.add(new Product("Coca-Cola", 1.7, "기분까지 상쾌해지는 코카 콜라"));
        beverageList.add(new Product("Vanilla Shake", 2.8, "신선한 우유에 달콤한 바닐라 시럽이 더해진 쉐이크"));
        beverageList.add(new Product("Orange Juice",2.0, "비타민 C 를 함유한 100% 오렌지 주스"));
        menuMap.put("Beverages", beverageList);
    }

    public void run() throws InterruptedException {
        screen = new Screen(menuList, menuMap);
        screen.display();
    }
}
