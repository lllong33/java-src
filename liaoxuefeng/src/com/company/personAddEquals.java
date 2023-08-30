package com.company;

import java.util.List;
import java.util.Objects;

public class personAddEquals {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 15),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist? "test Success":"test Failed");
    }
}

class Person{
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }
}
