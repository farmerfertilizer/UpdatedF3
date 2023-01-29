package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/manufacturerServiceFallBack")
    public String manufacturerServiceFallBackMethod() {
        return "Manufacturer Service is taking longer than Expected." +
                " Please try again later";
    }


    @GetMapping("/securityServiceFallBack")
    public String securityServiceFallBackMethod() {
        return "Security Service is taking longer than Expected." +
                " Please try again later";
    }
}