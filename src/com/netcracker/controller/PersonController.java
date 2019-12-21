package com.netcracker.controller;

import com.netcracker.model.Person;
import com.netcracker.model.PersonJobAddressType;
import com.netcracker.repos.PersonData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PersonController {

    @GetMapping("/persons")
    public String displayAllPersons(Model model) {
        model.addAttribute("title","All Persons");
        model.addAttribute( "persons", PersonData.getAll());
        return "persons/index";
    }

    @GetMapping("persons/create")
    public String displayCreatePersonForm(Model model){
        model.addAttribute("title", "Create Person");
        model.addAttribute(new Person());
        model.addAttribute("types", PersonJobAddressType.values());
        return "persons/create";
    }

    @PostMapping("persons/create")
    public String processCreatePersonForm(@ModelAttribute @Valid Person newPerson,
                                          Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Person");
            model.addAttribute("errorMsg", "Bad Data!");
            return "persons/create";
        }
        PersonData.add(newPerson);
        return "redirect:";
    }

    @GetMapping("persons/delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Persons");
        model.addAttribute("persons", PersonData.getAll());
        return "persons/delete";
    }

    @PostMapping("persons/delete")
    public String processDeletePersonsForm(@RequestParam(required = false) int[] personIds){
        if(personIds!= null) {
            for (int id : personIds) {
                PersonData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("persons/find")
    public String displayFindPersonForm(Model model){
        model.addAttribute("title", "Find Person");
        model.addAttribute("persons", PersonData.getAll());
        return "persons/find";
    }

    @PostMapping("persons/find")
    public String processDeletePersonsForm(@RequestParam String personName,
                                           @RequestParam String personEmail){
        if(PersonData.find(personName, personEmail)==0) {
            return "persons/success";
        }
        return "persons/find";
    }


}
