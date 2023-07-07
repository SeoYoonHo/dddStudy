package com.ddd.study.domain;

import com.ddd.study.enums.OrderState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private OrderState state;

    @OneToOne
    private ShippingInfo shippingInfo;

    public void changeShipped() {

    }

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        if (!state.isShippingChangeable()) {
            throw new IllegalStateException("can't change shipping in" + state);
        }
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {

    }

    public void completePayment() {

    }

    private boolean isShippingChangeable() {
        return state == OrderState.PREPARING || state == OrderState.PAYMENT_WAITING;
    }

}
