package com.yeadev.JavaSpringBootJARAngularSeed.jpa;

import com.yeadev.JavaSpringBootJARAngularSeed.jpa.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    // connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        // find_all_persons is a jpql define in the Person.class as an annotation
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);// JPA
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(long id) {
        Person person = findById(id);
        entityManager.remove(person);
    }
}