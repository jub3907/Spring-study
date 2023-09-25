package jpabook.jpashop.repository.order.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.Data;

@Data
public class OrderItemQueryDto {
    public OrderItemQueryDto(Long orderId, String itemName, int orderPrice, int count) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    private Long orderId;
    private String itemName;
    private int orderPrice;
    private int count;
}
