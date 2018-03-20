package com.yeadev.JavaSpringBootJARAngularSeed.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Data
@Entity
@NamedQuery(name="find_all_persons", query="select p from Person p")
// jpql = Java Persistence Query Language =  ref: https://www.thoughts-on-java.org/jpql/
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;
    private Date birthDate;

    public Person() {
        super();
    }

    public Person(long id, String name, String location, Date birthDate) {
        this(name, location, birthDate);
        this.id = id;
    }

    public Person(String name, String location, Date birthDate) {
        super();
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }
}