package com.netcracker.repos;

import com.netcracker.model.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PersonData {

    private static final Map<Integer, Person> persons = new HashMap<>();

    public static Collection<Person> getAll() {
        return persons.values();
    }

    public static Person getById(int id) {
        return persons.get(id);
    }

    public static void add(Person person) {
        persons.put(person.getId(), person);
    }

    public static void remove(int id) {
        persons.remove(id);
    }

    public static int find(String name, String email) {
        if (!persons.isEmpty()) {

            int count = 0;
            Iterator<Map.Entry<Integer, Person>> iterator = persons.entrySet().iterator();

            while (iterator.hasNext()){
                Map.Entry<Integer, Person> pair1 = iterator.next();
                Person value = pair1.getValue();
                if (value.getName().equals(name) && value.getEmail().equals(email)) {
                    return 0;
                }
            }
        }
        return -1;
    }
}