package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WelcomeHomeController {
        @GetMapping("/home")
        public String welcome() {
            return "home";
        }
    }


