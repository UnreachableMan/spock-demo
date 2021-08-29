package com.spock.demo.handler;

import com.spock.demo.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Handler {



    public String handler1(Long userId){
        System.out.println("handler1");
        return "返回1";
    }
    public String handler2(OrderDto orderDto){
        System.out.println("handler2");
        return "返回2";
    }
    public String handler3(){
        System.out.println("handler3");
        return "返回3";
    }
    public String handler4(){
        System.out.println("handler4");
        return null;
    }

    public String handler5(String param){
        System.out.println("handler5");
        return param;
    }
}
