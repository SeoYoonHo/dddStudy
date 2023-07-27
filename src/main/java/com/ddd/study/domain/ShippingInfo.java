package com.ddd.study.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ShippingInfo {
    @Id @GeneratedValue
    @Column(name = "shipping_id")
    private Long id;

    @OneToOne
    private Address address;
    private String receiverName;
    private String receiverPhoneNumber;
}
