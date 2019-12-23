package com.netcracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class SessionController {

    @GetMapping("/persons/session")
    public String sessionListener(HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession(true);

        Date creationTime=new Date(((HttpSession) session).getCreationTime());
        Date lastAccessedTime = new Date(session.getLastAccessedTime());
        String id=session.getId();

        return "Creation Time = "+creationTime +","
                +"Last access time = "+lastAccessedTime + ","
                +"Session id = "+id;
    }
}
