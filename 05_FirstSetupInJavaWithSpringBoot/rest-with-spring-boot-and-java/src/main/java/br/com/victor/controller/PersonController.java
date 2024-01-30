package br.com.victor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.victor.exceptions.UnsupportedMathOperationException;
import br.com.victor.model.Person;
import br.com.victor.service.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices personServices;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id")String id) {
		return personServices.findById(id);
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
			method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return convertDouble(numberOne) + convertDouble(numberTwo);
	}

	private Double convertDouble(String numberOne) {
		if(numberOne == null)
			return 0D;
		String number = numberOne.replaceAll(",", ".");
		if(isNumeric(number))
			return Double.parseDouble(number);
		return Double.parseDouble(numberOne);
	}

	private boolean isNumeric(String numberOne) {
		if(numberOne == null)
			return false;
		String number = numberOne.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}
	
}
