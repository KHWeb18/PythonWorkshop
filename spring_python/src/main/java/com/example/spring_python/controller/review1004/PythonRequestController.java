package com.example.spring_python.controller.review1004;

import com.example.spring_python.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class PythonRequestController {

    // Controller: URL 처리에 유리
    // RestController: 데이터(json) 처리에 유리
    @GetMapping("/springToPythonRequest")
    public ModelAndView doRequestPythonRest(Model model) {
        log.info("doRequestPythonRest");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                // 프로젝트 진행시에는 이 부분만 바꿔가면서 사용하게 될 것
                "http://localhost:5000/springToPythonRequest",
                String.class
        );

        log.info("result: " + result);

        // URL 처리하기 위해 아래 작업을 해야 함(pythonResult.html)
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("review1004/pythonResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    // 여러 개의 데이터 처리
    @GetMapping("/springToPythonRequestMulti")
    public ModelAndView doRequestPythonRestMulti(Model model) {
        log.info("doRequestPythonRestMulti");

        List<HttpMessageConverter<?>> converters =
                new ArrayList<>();

        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        String result = restTemplate.getForObject(
                "http://localhost:5000/springToPythonRequestMulti",
                String.class
        );

        log.info("result: " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("review1004/pythonResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }

    // 파이썬으로 데이터 전송하기
    @GetMapping("/springToPythonRequestWithData")
    public ModelAndView doRequestPythonRestWithData(Model model) {
        log.info("doRequestPythonRestWithData");

        RestTemplate restTemplate = new RestTemplate();

        Product product = new Product(35000);

        // Entity 형식의 객체를 전송해야 함
        String result = restTemplate.postForObject(
                "http://localhost:5000/springToPythonRequestWithData",
                product,
                String.class
        );

        log.info("result: " + result);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("review1004/pythonResult");

        model.addAttribute("resultMsg", result);

        return modelAndView;
    }
}























