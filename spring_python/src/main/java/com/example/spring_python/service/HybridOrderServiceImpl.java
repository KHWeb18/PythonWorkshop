package com.example.spring_python.service;

import com.example.spring_python.entity.HybridOrder;
import com.example.spring_python.repository.HybridOrderRepository;
import com.example.spring_python.request.RequestHybridOrder;
import com.example.spring_python.utility.PythonRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HybridOrderServiceImpl implements HybridOrderService{

    @Autowired
    HybridOrderRepository repository;

    @Override
    public Boolean registerOrder(RequestHybridOrder order) throws Exception {
        HybridOrder hybridOrder = new HybridOrder(order.getName(), order.getCost());
        repository.save(hybridOrder);

        return true;
    }

    @Override
    public String notice(RequestHybridOrder order) throws Exception {
        // Python으로 REST 요청을 수행해야 한다
        PythonRequestUtil pru = new PythonRequestUtil();

        // REST 요청을 하고 성공 여부를 받아 온다
        String result = pru.orderTest(order);

        return result;
    }
}















