package com.yuce.envanter.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public class ApiRest {

    public String test() {
        return "apihome";
    }

}