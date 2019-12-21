package com.netcracker.controller;

import com.netcracker.model.Person;
import com.netcracker.repos.PersonData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SigningUpController {

    //private PersonRepo userRepo;
    //private static List<Person> persons=new ArrayList<>();

    @GetMapping("/signup")
    public String signupForm(Model model) {
            model.addAttribute( "person", PersonData.getAll());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit( @RequestParam String name,
                                @RequestParam String lastName,
                                @RequestParam String thirdName,
                                @RequestParam byte age,
                                @RequestParam long salary,
                                @RequestParam String email,
                                @RequestParam String jobAddress) {
//        if(errors.hasErrors()){
//            model.addAttribute("person", new Person(name, lastName,thirdName, age, salary, email, jobAddress));
//            return "signup";
//        }

        //PersonData.add(new Person(name, lastName,thirdName, age, salary, email, jobAddress));

//        Cookie cookie = new Cookie("username", Person.get());
//        cookie.setMaxAge(24*60*60);
//
       // response.setStatus(1);
        //List<Person> listPerson = new ArrayList<>();
//        Person person=new Person();
//        person.setName(name);
//        person.setLastName(lastName);
//        person.setThirdName(thirdName);
//        person.setAge(age);
//        person.setSalary(salary);
//        person.setEmail(email);
//        person.setJobAddress(jobAddress);
//
//        userRepo.save(person);

        return "result";
    }

}
