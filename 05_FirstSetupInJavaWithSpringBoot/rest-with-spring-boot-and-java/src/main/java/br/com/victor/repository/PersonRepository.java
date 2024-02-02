package br.com.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.victor.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
