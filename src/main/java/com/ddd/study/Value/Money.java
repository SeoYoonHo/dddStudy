package com.ddd.study.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {
    private int value;

    // 메소드를 보면 항상 새로운 객체를 반환한다
    // 불변객체라는 의미
    public Money add(Money money) {
        return new Money(this.value + money.value);
    }
}
