package br.com.mytraining.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mytraining.entities.Person;
import br.com.mytraining.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

	@Autowired
	private PersonService service;

	@GetMapping
	public ResponseEntity<List<Person>> findAll() {

		List<Person> personList = service.findAll();

		return ResponseEntity.ok().body(personList);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {

		Person obj = service.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Person> create(@RequestBody Person obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
				
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person obj){
		
		obj = service.update(id, obj);
		
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
