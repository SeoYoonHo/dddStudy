package com.ddd.study.domain;

import com.ddd.study.enums.OrderState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private OrderState state;

    @OneToOne
    private ShippingInfo shippingInfo;

}
