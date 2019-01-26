package org.my.multi.module.three.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleApp")
public class WebController3 {

    @GetMapping("/helloAppThree")
    public String helloAppThree() {
        return "hello from app three";
    }

}
