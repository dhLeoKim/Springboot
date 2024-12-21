package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class MarketApi {

    public int connect() {
        // 실제 환율정보를 다른 서비스를 통해서 가져오기
        // 여기서는 임의로 1100원 고정
        return 1100;
    }
}
