package com.ddd.study.domain;

import com.ddd.study.Value.Money;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderLine {
    @Id
    private Long id;

    @OneToOne
    private Product product;
    @Embedded
    private Money price;
    private int quantity;
    private int amounts;

    public OrderLine() {

    }

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private int calculateAmounts() {
        return price.getValue() * quantity;
    }

}
