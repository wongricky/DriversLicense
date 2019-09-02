package com.rickywong.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickywong.relationships.models.Person;
import com.rickywong.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository pRepo;
	
	public PersonService(PersonRepository pRepo) {
		this.pRepo = pRepo;
	}
	
	public Person createPerson(Person person) {
		return pRepo.save(person);
	}
	
	public List<Person> allPeople(){
		return pRepo.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = pRepo.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
	}
}
