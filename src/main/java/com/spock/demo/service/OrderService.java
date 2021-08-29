package com.spock.demo.service;

import com.spock.demo.exception.OrderException;
import com.spock.demo.param.OrderCreateParam;
import com.spock.demo.param.PayOrderParam;

public interface OrderService {
    /**
     * 创建订单
     * @param param
     */
    Long createOrder(OrderCreateParam param) throws OrderException;

    /**
     * 支付订单
     */
    void payOrder(PayOrderParam param);

    /**
     * 取消订单
     */
    void cancellOrder(Long orderId);
}
