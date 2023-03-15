package com.example.thymeleafformdemo.controllers;

import com.example.thymeleafformdemo.model.Person;
import com.example.thymeleafformdemo.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("person")
@Controller
public class PersonController {

  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  //First Form Handling demo
  @GetMapping("/create")
  public String showForm(Model model) {
    //create new empty Person object
    model.addAttribute("person", new Person());
    return "createPersonForm";
  }

  @PostMapping("/save")
  public String personSave(@ModelAttribute Person person, Model model) {
    //save populated Person object in database
    personService.save(person);
    //find person again in database
    Person personNew = personService.findPerson(person.getName());
    model.addAttribute("person", personNew);
    return "showCreatePersonResult";
  }

  //Select object from list
  @GetMapping("/showall")
  public String getAll(Model model) {
    List<Person> personList = personService.findAll();
    // add list of Person objects into model
    model.addAttribute("people", personList);
    return "allPersons";
  }

  @PostMapping("/chosenPerson")
  public String choosePerson(@ModelAttribute Person person) {
    // Som test vises kun valgte person i IJ's output vindue vha, sout
    // Man burde selvfølgelig vise valgt person på en html side.
    System.out.println("data fra form " + person.getId() + " " + person.getName() + " " + person.getAge());
    return "redirect:/person/showall";
  }

  // Brug af URL link
  @GetMapping("/showall2")
  public String getAll2(Model model) {
    List<Person> personList = personService.findAll();
    model.addAttribute("people", personList);
    return "allPersons2";
  }

  @GetMapping("/single/{id}")
  public String singlePathVariable(@PathVariable("id") int id, Model model) {
    List<Person> result = personService.findAll();
    Person found = null;
    for (Person person : result) {
      if (person.getId() == id) {
        found = person;
      }
    }
    model.addAttribute("person", found);
    return "details";
  }

  @GetMapping("/details")
  public String details(@RequestParam int id, Model model) {
    List<Person> result = personService.findAll();
    Person found = null;
    for (Person person : result) {
      if (person.getId() == id) {
        found = person;
      }
    }
    model.addAttribute("person", found);
    return "details";
  }
}


