package com.netcracker.controller;


//import com.netcracker.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @PostMapping("/")
    public String greetingSubmit(Model model){

        return "result";
    }

}