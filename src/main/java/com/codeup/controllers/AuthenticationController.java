package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by canidmars on 6/23/17.
 */

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
