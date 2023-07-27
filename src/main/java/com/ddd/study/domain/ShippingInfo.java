package com.ddd.study.domain;

import com.ddd.study.Value.Address;
import com.ddd.study.Value.Receiver;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShippingInfo {
    @Id
    @GeneratedValue
    @Column(name = "shipping_id")
    private Long id;
    @Embedded
    private Address address;
    @Embedded
    private Receiver receiver;
}
