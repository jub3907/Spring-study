package hello.itemservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity // JPA에서 관리한다.
public class Item {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 값을 증가
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
