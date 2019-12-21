package com.netcracker.controller;

import com.netcracker.model.Person;
import com.netcracker.repos.PersonData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    private static List<Person> persons=new ArrayList<>();

    @GetMapping("/persons")
    public String displayAllPersons(Model model) {
        model.addAttribute("title","All Persons");
        model.addAttribute( "persons", persons);
        return "persons/index";
    }

    @GetMapping("persons/create")
    public String displayCreatePersonForm(Model model){
        model.addAttribute("title", "Create Person");
        return "persons/create";
    }

    @PostMapping("persons/create")
    public String processCreatePersonForm(  @RequestParam String personName,
                                            @RequestParam String lastName){
        persons.add(new Person(personName, lastName));
        return "redirect:";
    }


}
