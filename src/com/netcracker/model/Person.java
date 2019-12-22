package com.netcracker.model;

import javax.validation.constraints.*;
import java.util.Objects;

public class Person {
    private int id;
    private static int nextId = 1;
    @NotBlank
    @Size(min=1, max=50, message = "Have must be between 1 and 50 characters")
    private String name;

    @Size(min=1, max=50, message = "Have must be between 1 and 50 characters")
    private String lastName;

    @Size(min=1, max=50, message = "Have must be between 1 and 50 characters")
    private String thirdName;

    @DecimalMin(value="16", inclusive = false)
    private int age=17;

    @DecimalMax(value="1000000", inclusive = false)
    private int salary;

    @NotBlank
    @Email(message = "Invalid email. Try again")
    private String email;

    private PersonJobAddressType jobAddress; //enum

    public Person(){
        this.id = nextId;
        nextId++;
    }

    //for find
    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Person(String name, String lastName, String thirdName, int age, int salary, String email, PersonJobAddressType jobAddress) {
        this();
        this.name = name;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.jobAddress = jobAddress;
    }
//
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public PersonJobAddressType getJobAddress() {
        return jobAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobAddress(PersonJobAddressType jobAddress) {
        this.jobAddress = jobAddress;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


