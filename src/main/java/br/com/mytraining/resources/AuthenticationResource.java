package br.com.mytraining.resources;

import br.com.mytraining.dtos.CredentialsDTO;
import br.com.mytraining.dtos.LoginResponseDTO;
import br.com.mytraining.dtos.PersonDTO;
import br.com.mytraining.entities.Person;
import br.com.mytraining.security.TokenService;
import br.com.mytraining.security.UserSecurity;
import br.com.mytraining.services.AuthorizationService;
import br.com.mytraining.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationResource {
	

	@Autowired
	private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody @Valid CredentialsDTO credentials) {
    	
    	//var userDetails = authorizationService.loadUserByUsername(credentials.getEmail());
        var usernamePassword = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserSecurity) auth.getPrincipal());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("access-control-expose-headers", "Authorization");
        httpHeaders.set("Authorization", "Bearer "+ token);

        return ResponseEntity.ok().headers(httpHeaders).body(new LoginResponseDTO(token));

    }


    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid PersonDTO data) {

        Person person = personService.create(data);

        if(data.getId() == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().build();


    }


}
