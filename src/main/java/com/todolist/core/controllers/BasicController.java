package com.todolist.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that is used for getting the home page
 */
@Controller
public class BasicController {
    /**
     * Return tha home page on URL "/"
     * @return Home page
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
