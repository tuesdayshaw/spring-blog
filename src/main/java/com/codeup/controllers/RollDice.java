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

    @GetMapping("/roll-dice")
    public String viewPage() {
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{n}")
    public String randomNumberGenerator(@PathVariable double n, Model model) {
        double randomNumber1 = Math.floor(Math.random()* 5) + 1;
        double randomNumber2 = Math.floor(Math.random()* 5) + 1;
        double randomNumber3 = Math.floor(Math.random()* 5) + 1;
        double randomNumber4 = Math.floor(Math.random()* 5) + 1;
        double randomNumber5 = Math.floor(Math.random()* 5) + 1;

        model.addAttribute("randomNumber1", randomNumber1);
        model.addAttribute("randomNumber2", randomNumber2);
        model.addAttribute("randomNumber3", randomNumber3);
        model.addAttribute("randomNumber4", randomNumber4);
        model.addAttribute("randomNumber5", randomNumber5);
        model.addAttribute("n", n);

        boolean match = (n == randomNumber1) || (n == randomNumber2) || (n == randomNumber3) || (n == randomNumber4) || (n == randomNumber5);

        model.addAttribute("match", match);

        return "roll-dice";
    }

}
