package br.com.mytraining.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mytraining.entities.Person;
import br.com.mytraining.repositories.PersonRepository;
import br.com.mytraining.security.UserSecurity;

@Service
public class AuthorizationService implements UserDetailsService {


    @Autowired
    private PersonRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = repository.findByEmail(username);
        if (person == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new UserSecurity(person.getId(), person.getEmail(), person.getPassword(), person.getProfiles());
    }
    
}
