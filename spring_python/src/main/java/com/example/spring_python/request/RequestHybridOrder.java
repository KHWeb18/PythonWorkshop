package com.example.spring_python.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestHybridOrder {
    private String name;
    private Integer cost;
}
