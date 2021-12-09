package com.example.spring_python.service;

import com.example.spring_python.request.RequestHybridOrder;

public interface HybridOrderService {
    Boolean registerOrder(RequestHybridOrder order) throws Exception;
    String notice(RequestHybridOrder order) throws Exception;
}
