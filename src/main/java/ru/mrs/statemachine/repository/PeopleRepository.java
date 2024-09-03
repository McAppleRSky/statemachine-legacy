package ru.mrs.statemachine.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import ru.mrs.statemachine.entity.MyObject;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrs.statemachine.entity.catalog.people.People;

public interface PeopleRepository extends JpaRepository<People, Long> {

//    @Override List<MyObject> findAll();

}
