package br.com.victor.service;

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
		
		
}
