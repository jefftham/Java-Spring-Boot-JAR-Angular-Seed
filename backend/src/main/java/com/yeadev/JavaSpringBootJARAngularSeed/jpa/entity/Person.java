package com.yeadev.JavaSpringBootJARAngularSeed.jpa.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
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