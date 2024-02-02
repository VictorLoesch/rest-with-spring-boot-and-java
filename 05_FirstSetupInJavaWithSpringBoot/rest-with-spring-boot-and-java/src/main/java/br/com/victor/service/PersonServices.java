package br.com.victor.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victor.exceptions.ResourceNotFoundException;
import br.com.victor.model.Person;
import br.com.victor.repository.PersonRepository;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private PersonRepository personRepository;
	
	public Person findById(Long id) {
		logger.info("Finding one person");
		return personRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person create(Person person) {
		logger.info("Creating one person");
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Update one person");
		
		Person entity = personRepository.findById(person.getId()).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return personRepository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Delete one Person!");
		personRepository.deleteById(id);
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
