package com.ddd.study.domain;

import com.ddd.study.enums.OrderState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany
    private List<OrderLine> orderLines;
    private int totalAmounts;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public Order() {

    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // 최소 1개 이상 주문 한다는 유효성 검사 체크
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = orderLines.stream().mapToInt(OrderLine::getAmounts).sum();
    }

    public void changeShipped() {

    }

    // 주문과 관련된 규칙들을 서비스 계층이 아닌 Order 도메인 계층에서 처리한다
    // --> 이를 도메인 모델 패턴이라 함
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
