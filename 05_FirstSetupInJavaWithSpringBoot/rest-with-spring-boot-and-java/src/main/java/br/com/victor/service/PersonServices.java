package br.com.victor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.victor.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {
		logger.info("Finding one person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Victor");
		person.setLastName("Elias");
		person.setAdress("Aguas claras");
		person.setGender("Masculino");
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i <= 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person create(Person person) {
		logger.info("Creating one person");
		person.setId(counter.incrementAndGet());
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Update one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Delete one Person!");
	}
	
	
	private Person mockPerson(int i) {
		logger.info("Find All people");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Victor");
		person.setLastName("Elias");
		person.setAdress("Aguas claras");
		person.setGender("Masculino");
		return person;
	}
}
