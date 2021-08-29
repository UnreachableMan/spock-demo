package com.spock.demo.rpc;

import org.springframework.stereotype.Service;

@Service("payRpcClass")
public class PayRpcClassImpl implements PayRpcClass{
    @Override
    public String invoke1(String param) {
        return null;
    }
}
