package com.yuce.envanter.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiRest {


    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "endpoints";
    }

}