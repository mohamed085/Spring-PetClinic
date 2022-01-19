package com.demo.sfgpetclinic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class indexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index() {
        log.info("Request index Page");
        return "index";
    }

    @RequestMapping({ "/oups", "/oups.html"})
    public String oups() {
        log.info("Request oups Page");

        return "NotImplemented";
    }
}
