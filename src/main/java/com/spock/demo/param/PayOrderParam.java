package com.spock.demo.param;

import com.spock.demo.enums.OrderTypeEnum;

public class PayOrderParam {

    private String OrderNo;

    private OrderTypeEnum type;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public OrderTypeEnum getType() {
        return type;
    }

    public void setType(OrderTypeEnum type) {
        this.type = type;
    }
}
