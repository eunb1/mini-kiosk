# 🍔 맥도날드 키오스크

순수 Java 언어를 이용하여 간단한 패스트푸드점 키오스크를 만들어 보았습니다.

#### 실행 예시:
![screenshot1](./img/screenshot1.png) |![screenshot2](./img/screenshot2.png)
| --- | --- |

## ⚙️ 프로그램 필수 요구 사항

1. 메인 메뉴판 화면
    - 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력됩니다.
    - 상품 메뉴는 간단한 설명과 함께 출력되며 최소 3개 이상 출력됩니다.
    - 상품 메뉴 아래에는 Order(주문)와 Cancel(주문취소) 옵션을 출력해줍니다.

2. 상품 메뉴판 화면
    - 상품 메뉴 선택시 해당 카테고리의 메뉴판이 출력됩니다.
    - 메뉴판에는 각 메뉴의 이름과 가격과 간단한 설명이 표시됩니다.

3. 구매 화면
    - 상품 선택시 해당 상품을 장바구니에 추가할지 확인하는 문구가 출력됩니다.
    - `1.확인` 입력시 장바구니에 추가되었다는 안내문구와 함께 메인메뉴로 다시 출력됩니다.

4. 주문 화면
    - `5.Order` 입력시 장바구니 목록을 출력해줍니다.
    - 장바구니에서는 추가된 메뉴들과 총 가격의 합을 출력해줍니다.
    - `1.주문` 입력시 주문완료 화면으로 넘어가고, `2.메뉴판` 입력시 다시 메인메뉴로 돌아옵니다.

5. 주문완료 화면
    - `1.주문` 입력시 대기번호를 발급해줍니다.
    - 장바구니는 초기화되고 3초후에 메인 메뉴판으로 돌아갑니다.

6. 주문취소 화면
    - 메뉴판에서 `6.Cancel` 입력시 주문을 취소할지 확인을 요청하는 문구가 출력됩니다.
    - `1.확인` 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력됩니다.

## ⚙️ 추가 요구 사항

1. 주문개수 기능 추가
    - 장바구니에 똑같은 상품이 담기면 주문 화면에서 상품 개수가 출력되도록 합니다.

2. 상품옵션 기능 추가
    - 상품에 옵션을 선택 후 장바구니에 추가 할 수 있게 세분화 합니다.

3. 총 판매금액 조회 기능 추가
    - 구매가 완료될때마다 총 판매 금액을 누적해줍니다.
    - 숨겨진 기능으로 0번 입력시 총 판매금액을 출력합니다.

4. 총 판매상품 목록 조회 기능 추가
    - 구매가 완료될때마다 판매 상품 목록을 저장해줍니다.
    - 숨겨진 기능으로 0번 입력시 총 판매 상품목록을 출력합니다.


