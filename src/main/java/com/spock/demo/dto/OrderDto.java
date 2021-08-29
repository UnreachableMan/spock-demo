package com.spock.demo.dto;

import com.spock.demo.enums.OrderTypeEnum;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    private OrderTypeEnum type;
    private BigDecimal price;
    private List<String> items;
    private Long userId;


    public OrderTypeEnum getType() {
        return type;
    }

    public void setType(OrderTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
