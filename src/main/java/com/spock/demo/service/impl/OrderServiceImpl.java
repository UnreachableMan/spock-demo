package com.spock.demo.service.impl;

import com.spock.demo.exception.OrderException;
import com.spock.demo.handler.Handler;
import com.spock.demo.param.OrderCreateParam;
import com.spock.demo.param.PayOrderParam;
import com.spock.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Handler handler;


    @Override
    public Long createOrder(OrderCreateParam param) throws OrderException {

        //1、幂等性以及各种参数核对
        param.checkParam();
        if (param.getUserId() == 000001L) {
            throw new RuntimeException("已经下单，请稍等");
        }
        switch (param.getType()) {

            case TYPE1:
                handler.handler1();
                break;
            case TYPE2:
                handler.handler2();
                break;
            case TYPE3:
                handler.handler3();
                break;
            case TYPE4:
                handler.handler4();
                break;
            default:
                throw new OrderException("订单类型异常");
        }

        return 1L;

    }

    @Override
    public void payOrder(PayOrderParam param) {

    }

    @Override
    public void cancellOrder(Long orderId) {

    }

}
