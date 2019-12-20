package com.netcracker.controller;

//import com.netcracker.model.Greeting;
import com.netcracker.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
         model.addAttribute( "greeting", new Person());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Person greeting, HttpServletResponse response) {

//        Cookie cookie = new Cookie("username", Person.get());
//        cookie.setMaxAge(24*60*60);
//
       // response.setStatus(1);

        return "result";
    }

}
