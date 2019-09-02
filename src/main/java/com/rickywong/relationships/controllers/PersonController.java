package com.rickywong.relationships.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rickywong.relationships.models.License;
import com.rickywong.relationships.models.Person;
import com.rickywong.relationships.services.LicenseService;
import com.rickywong.relationships.services.PersonService;

@Controller
public class PersonController {
	private final PersonService pService;
	private final LicenseService lService;
	
	public PersonController(PersonService pService, LicenseService lService) {
		this.pService = pService;
		this.lService = lService;
	}
	
	
	// Initialize person
	@RequestMapping("persons/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		List<Person> persons = pService.allPeople();
		model.addAttribute("persons", persons);
		return "persons/new.jsp";
	}
	
	// Create new Person
	@PostMapping("persons/new")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "persons/new.jsp";
		}
		else {
			pService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	@RequestMapping(value="/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = pService.findPerson(id);
		model.addAttribute("person", person);
		return "persons/show.jsp";
	}
	
	// Create new License
	@RequestMapping("licenses/new")
	public String newLicense(@ModelAttribute("license") License license) {
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(value="licenses/new", method=RequestMethod.POST)
	public String createLicense(@ModelAttribute("license") License license, @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println("****ERROR****");
			return "/licenses/new.jsp";
		}
		else {
			System.out.println("****PASSED****"); 
			List<Person> pList = pService.allPeople(); // Populate drop down menu with persons
			Map<String, String> map = new HashMap<>();
			for (Person p : pList) {
				map.put(String.valueOf(p.getId()), String.format("%s %s", p.getFirstName(), p.getLastName()));
			}
			model.addAttribute("persons", map);
			model.addAttribute("state", license.getState());
			return "/license/new";
		}
	}
	
	
	
}
