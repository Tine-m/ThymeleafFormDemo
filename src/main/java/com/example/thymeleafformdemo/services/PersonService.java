package com.example.thymeleafformdemo.services;

import com.example.thymeleafformdemo.model.Person;
import com.example.thymeleafformdemo.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  private PersonRepository personRepo;

  public PersonService(PersonRepository personRepo) {
    this.personRepo = personRepo;
  }


  public void save(Person person) {
    personRepo.save(person);
  }

  public Person findPerson(String name) {
    return personRepo.findPerson(name);
  }

  public List<Person> findAll() {
    return personRepo.findAll();
  }
}