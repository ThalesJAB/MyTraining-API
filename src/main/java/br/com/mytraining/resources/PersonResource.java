package br.com.mytraining.resources;

import br.com.mytraining.dtos.PersonDTO;
import br.com.mytraining.entities.Person;
import br.com.mytraining.services.PersonService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/persons")
public class PersonResource {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {

        return ResponseEntity.ok().body(service.findAll().stream().map(person -> mapper.map(person, PersonDTO.class)).collect(Collectors.toList()));

    }

    @PreAuthorize("hasAnyRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {

        Person obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody PersonDTO obj) {
        Person newPerson = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPerson.getId()).toUri();
        return ResponseEntity.created(uri).body(newPerson);


    }

    @PreAuthorize("hasAnyRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @Valid @RequestBody Person obj) {

        obj = service.update(id, obj);


        return ResponseEntity.ok().body(obj);

    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
