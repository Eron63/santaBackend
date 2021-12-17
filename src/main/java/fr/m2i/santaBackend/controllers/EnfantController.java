package fr.m2i.santaBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.santaBackend.services.UserService;
import fr.m2i.santaBackend.user.FindEnfantDTO;
import fr.m2i.santaBackend.user.FindUserDTO;

@RestController
@RequestMapping("enfants")
@CrossOrigin
public class EnfantController {
	@Autowired
    UserService service;	   
    
    @GetMapping()
    public ResponseEntity<List<FindEnfantDTO>> findAllEnfant() {
        return ResponseEntity.ok(this.service.findAllEnfant());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> findByIdEnfant(@PathVariable Long id) {
    	Optional<FindUserDTO> findDTO = this.service.findByIdEnfant(id);
    	
    	if(findDTO.isPresent())
    	{
    		return new ResponseEntity<>(findDTO.get(), HttpStatus.OK);		        
    	}
    	else
    	{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }

}
