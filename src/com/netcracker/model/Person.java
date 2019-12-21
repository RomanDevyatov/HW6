package com.netcracker.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Person {
//    private int id;
//    private static int nextId = 1;
//    @NotNull
//    @Size(min=2, max=25)
    private String name;
//    @NotNull
    private String lastName;
//    private String thirdName;
//    private byte age;
//    private long salary;
//    @NotNull
//    @Size(min=1, message = "Email")
//    private String email;
//    private String jobAddress;

    public Person(String name, String lastName) {
        //this.id = nextId;
        this.name = name;
        this.lastName = lastName;
//        this.thirdName = thirdName;
//        this.age = age;
//        this.salary = salary;
//        this.email = email;
//        this.jobAddress = jobAddress;
//        nextId++;
    }
//
//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
//
//    public String getThirdName() {
//        return thirdName;
//    }
//
//    public byte getAge() {
//        return age;
//    }
//
//    public long getSalary() {
//        return salary;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getJobAddress() {
//        return jobAddress;
//    }
//
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public void setThirdName(String thirdName) {
//        this.thirdName = thirdName;
//    }
//
//    public void setAge(byte age) {
//        this.age = age;
//    }
//
//    public void setSalary(long salary) {
//        this.salary = salary;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setJobAddress(String jobAddress) {
//        this.jobAddress = jobAddress;
//    }

    @Override
    public String toString() {
        return getName();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Person person = (Person) o;
//
//        return id == person.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}


