package com.example.spring_python.controller.review1005;

import com.example.spring_python.request.RequestHybridOrder;
import com.example.spring_python.service.HybridOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HybridOrderController {

    @Autowired
    HybridOrderService service;

    @PostMapping("/order")
    public Boolean hybridOrder(@RequestBody RequestHybridOrder order) throws Exception {
        log.info("hybridOrder: " + order);

        Boolean registerSuccess = service.registerOrder(order);
        String check = service.notice(order);
        log.info("notice check: " + check);

        if (!registerSuccess) {
            return false;
        }

        return true;
    }
}





















