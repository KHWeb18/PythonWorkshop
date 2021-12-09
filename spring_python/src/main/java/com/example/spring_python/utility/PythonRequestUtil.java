package com.example.spring_python.utility;

import com.example.spring_python.request.RequestHybridOrder;
import org.springframework.web.client.RestTemplate;

public class PythonRequestUtil {

    public String orderTest(RequestHybridOrder order) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.postForObject(
                "http://localhost:5000/orderTest",
                order,
                String.class
        );
    }
}















