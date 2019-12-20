package com.netcracker.controller;

import com.netcracker.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String login(Model model) {
        model.addAttribute( "pers", new Person());
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(){
        return "result";
    }

}
