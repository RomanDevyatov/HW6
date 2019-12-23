package com.netcracker.repos;

import com.netcracker.model.Person;
import com.netcracker.model.PersonJobAddressType;

import java.io.*;
import java.util.*;

public class PersonData {

    private static final Map<Integer, Person> persons = new HashMap<>();


    public static Collection<Person> getAll() {
        return persons.values();
    }

    public static void writeInFile() throws IOException {
        try ( PrintWriter writer = new PrintWriter(new File("resources/output.txt")) ) {
            for ( Map.Entry<Integer, Person> entry : persons.entrySet() ) {
                writer.write( entry.getKey() + " " + entry.getValue().getName() +" " + entry.getValue().getLastName()+" " + entry.getValue().getThirdName()+" " + entry.getValue().getAge()+" " + entry.getValue().getSalary()+" " + entry.getValue().getEmail()+" " + entry.getValue().getJobAddress() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() throws IOException {
        File file = new File("resources/persons.txt");
        Scanner scanFile = new Scanner(file);
        int count = 0;
        while (scanFile.hasNextLine()) {
            scanFile.nextLine();
            count++;
        }
        scanFile.close();

        String slova[] = new String[count];
        Scanner scanFile2 = new Scanner(file);
        for (int i = 0;i < slova.length;i++){
            slova[i] = scanFile2.nextLine();
            String[] lineWords = slova[i].split(" ");
            String name = lineWords[0];
            String lastName = lineWords[1];
            String thirdName = lineWords[2];
            int age = Integer.parseInt(lineWords[3]);
            int salary = Integer.parseInt(lineWords[4]);
            String email = lineWords[5];
            String address = lineWords[6];

            PersonData.add(new Person(name, lastName, thirdName, age, salary, email, PersonJobAddressType.toPersonJobAddressType(address)));
        }
        scanFile2.close();
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

    public static List<Person> findByNameLastName(String name, String lastName) {
        if (!persons.isEmpty()) {
            List<Person> personList=new LinkedList<>();

            int count = 0;
            Iterator<Map.Entry<Integer, Person>> iterator = persons.entrySet().iterator();

            while (iterator.hasNext()){
                Map.Entry<Integer, Person> pair1 = iterator.next();
                Person value = pair1.getValue();
                if (value.getName().equals(name) && value.getLastName().equals(lastName)) {
                    personList.add(value);
                }
            }
            return personList;
        }
        return null;
    }



    public static int findByNameEmail(String name, String email) {
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