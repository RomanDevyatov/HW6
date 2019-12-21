package com.netcracker.repos;

import com.netcracker.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonData {

    private static final Map<Integer, Person> persons=new HashMap<>();

    public static Collection<Person> getAll(){
        return persons.values();
    }

//    public static Person getById(int id){
//        return persons.get(id);
//    }
////
////    public static void add(Person person) {
////        persons.put(person.getId(), person);
//    }

    public static void remove(int id){
        persons.remove(id);
    }

}
