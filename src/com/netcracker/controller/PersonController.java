package com.netcracker.controller;

import com.netcracker.model.Person;
import com.netcracker.model.PersonJobAddressType;
import com.netcracker.repos.PersonData;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.net.URLConnection;
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

    @GetMapping("/persons/download")
    public void doDownload(HttpServletResponse response) throws IOException {

        File downloadFile = new File("E:\\Java\\hw6-1\\\\resources\\download\\output.txt");
        InputStream inputStream= new BufferedInputStream((new FileInputStream(downloadFile)));
        String mimeType= URLConnection.guessContentTypeFromStream(inputStream);

        if(mimeType==null){
            mimeType= "application/msword";
        }

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        response.setHeader("Content-Diposition", String.format("attachment; filename=\"$s\"", downloadFile.getName()));

        FileCopyUtils.copy(inputStream, response.getOutputStream());
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

    public UserAgent toKnowUserAgent(HttpServletRequest request){
        return UserAgent.parseUserAgentString((request.getHeader("User-Agent")));
    }

    @PostMapping("persons/find")
    public String processFindPersonsForm(@RequestParam String personName,
                                         @RequestParam String personLastName,
                                         Model model, HttpServletRequest request){

        List<Person> perList=PersonData.findByNameLastName(personName, personLastName);
        if(perList.size()>0) {
            model.addAttribute("findpersons", perList);
            String accessTime="Time = " + new Date();
            model.addAttribute("accessTime", accessTime);
            model.addAttribute("userAgent",  toKnowUserAgent(request));
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
                                         Errors errors,
                                         Model model){
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
