package com.example.thymeleafformdemo.repositories;

import com.example.thymeleafformdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

  //Stub version of database

  private List<Person> list = new ArrayList<>();

  public PersonRepository() {
    list.add(new Person(1, "Fred", 25));
    list.add(new Person(2, "Lisa", 27));
    list.add(new Person(3, "Tom", 17));

  }

  public Person findPerson(String name) {
    for (Person p: list) {
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;
  }

  public List<Person> findAll() {
    return list;
  }

  public void save(Person person) {
    list.add(person);
  }
}
