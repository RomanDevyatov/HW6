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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
                                          Errors errors, Model model) throws IOException {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Person");
            return "persons/create";
        }
        PersonData.add(newPerson);
        PersonData.writeInFile();
        return "redirect:";
    }

    @GetMapping("persons/delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title", "Delete Persons");
        model.addAttribute("persons", PersonData.getAll());
        return "persons/delete";
    }

    @PostMapping("persons/delete")
    public String processDeletePersonsForm(@RequestParam(required = false) int[] personIds) throws IOException {
        if(personIds!= null) {
            for (int id : personIds) {
                PersonData.remove(id);
            }
            PersonData.writeInFile();
        }
        return "redirect:";
    }

    @GetMapping("persons/find")
    public String displayFindPersonForm(Model model){
        model.addAttribute("title", "Find Person");
        model.addAttribute(new Person());
        model.addAttribute("persons", PersonData.getAll());
        return "persons/find";
    }
//    @ModelAttribute @Valid Person newFindPerson,
//    Errors errors,
    @PostMapping("persons/find")
    public String processFindPersonsForm(@RequestParam String personName,
                                         @RequestParam String personLastName,
                                         Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);
        Date creationTime=new Date(((HttpSession) session).getCreationTime());
        Date lastAccessedTime = new Date(session.getLastAccessedTime());
        String id=session.getId();
//        if(errors.hasErrors()) {
//            model.addAttribute("title", "Not Found, try again");
//            return "persons/find";
//        }

        List<Person> perList=PersonData.findByNameLastName(personName, personLastName);
        if(perList.size()>0) {
            model.addAttribute("findpersons", perList);
            String accessTime="access time = "+lastAccessedTime.toString();
            String sessionId="Session id = "+id.toString();
            model.addAttribute("accessTime", accessTime);
            model.addAttribute("sessionId", sessionId);
            return "persons/findsuccess";
        }
        model.addAttribute("title", "Find person. Not Found, try again!");
        return "persons/find";
    }


    @GetMapping("persons/login")
    public String displayLoginPersonForm(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new Person());
        model.addAttribute("persons", PersonData.getAll());
        return "persons/login";
    }

    @PostMapping("persons/login")
    public String processLoginPersonForm(@ModelAttribute @Valid Person newFindPerson,
                                           Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Login. Uncorrected, try again");
            return "persons/login";
        }
        if(PersonData.findByNameEmail(newFindPerson.getName(), newFindPerson.getEmail())==0) {
            return "persons/loginsuccess";
        }
        model.addAttribute("title", "Login. Uncorrected, try again");
        return "persons/login";
    }
}
