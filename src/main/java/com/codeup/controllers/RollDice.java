package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by canidmars on 6/19/17.
 */

@Controller
public class RollDice {


    @GetMapping("/roll-dice/{n}")
    public String randomNumberGenerator(@PathVariable Double n, Model model) {
        double randomNumber = Math.floor(Math.random()* 5) + 1;

        model.addAttribute("randomNumber", randomNumber);
        model.addAttribute("n", n);

        boolean match = (n == randomNumber);

        model.addAttribute("match", match);
        return "roll-dice";

    }


}
