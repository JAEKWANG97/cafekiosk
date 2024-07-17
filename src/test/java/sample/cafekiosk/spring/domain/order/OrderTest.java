package sample.cafekiosk.spring.domain.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductType;


class OrderTest {

    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    void calculateTotalPrice() {
        // given
        List<Product> products = List.of(createProduct("001", 1000),
                                         createProduct("002", 2000));

        // when
        Order order = Order.create(products);

        // then
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(3000);

    }

    @DisplayName("주문 생성 시 주문 받는 상태는 INIT이다.")
    @Test
    void init() {
        // given
        List<Product> products = List.of(createProduct("001", 1000),
                                         createProduct("002", 2000));

        // when
        Order order = Order.create(products);

        // then
        Assertions.assertThat(order.getOrderStatus()).isEqualTo(OrderStatus.INIT);

    }

    private Product createProduct(String productNumber, int price) {
        return Product.builder()
                .type(ProductType.HANDMADE)
                .productNumber(productNumber)
                .price(price)
                .name("메뉴 이름")
                .build();
    }
}