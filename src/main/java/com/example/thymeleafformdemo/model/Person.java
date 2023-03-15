package com.example.thymeleafformdemo.model;

public class Person {

  private long id;
  private String name;
  private int age;

  public Person() {
    id = 1; //hardkodet til test. Database skal sørge for at generere unikke primærnøgler
  }

  public Person(long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

