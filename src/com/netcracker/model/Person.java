package com.netcracker.model;

public class Person {
    private String name;
    private String lastName;
    private String thirdName;
    private byte age;
    private long salary;
    private String email;
    private String jobAddress;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public byte getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getJobAddress() {
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

    public void setAge(byte age) {
        this.age = age;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }
}


