package com.netcracker;

import com.netcracker.repos.PersonData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringBootStarter {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringBootStarter.class, args);
        PersonData.readFromFile();
    }

}
