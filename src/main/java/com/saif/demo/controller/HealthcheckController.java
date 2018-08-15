package com.saif.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saif.demo.pojo.APIResponse;

@RestController
@RequestMapping(value = "")
public class HealthcheckController {

    @RequestMapping(value = "ping", method = RequestMethod.GET)
    public APIResponse ping() {
        return new APIResponse("pong");
    }

}
