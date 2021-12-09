package com.example.spring_python.controller.review1104;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/webgl")
public class BackShotController {

    @GetMapping("/backShot")
    public String getBackShot() {
        log.info("getBackShot()");

        return "review1104/back_shot";
    }
}
