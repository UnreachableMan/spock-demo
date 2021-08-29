package com.spock.demo.param;

import com.spock.demo.enums.OrderTypeEnum;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;


public class OrderCreateParam {
    public OrderTypeEnum getType() {
        return type;
    }

    public void setType(OrderTypeEnum type) {
        this.type = type;
    }

    private OrderTypeEnum type;
    private BigDecimal price;
    private List<String> items;
    private Long userId;



    public void checkParam(){

        if (userId ==null || type ==null || price == null || CollectionUtils.isEmpty(items)){
            throw new RuntimeException("参数不合法");
        }
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
