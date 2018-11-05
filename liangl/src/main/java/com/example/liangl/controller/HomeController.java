package com.example.liangl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by cpekl-ddim-2 on 11/5/18.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String home() {

        return "home";

    }
}
