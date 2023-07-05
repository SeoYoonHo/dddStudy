package com.ddd.study.enums;

public enum OrderState {
    PAYMENT_WAITING {
        public boolean isShippingChangeable() {
            return false;
        }
    },
    PREPARING {
        public boolean isShippingChangeable() {
            return false;
        }
    },
    SHIPPED, DELIVERING, DELIVERY_COMPLETED;

    public boolean isShippingChangeable() {
        return false;
    }
}
