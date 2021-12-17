package fr.m2i.santaBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.m2i.santaBackend.services.UserService;
import fr.m2i.santaBackend.user.*;


@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
	
	    @Autowired
	    UserService service;

	    @GetMapping
	    public ResponseEntity<List<FindUserDTO>> findAll() {
	        return ResponseEntity.ok(this.service.findAll());
	    }
	    	    
	    @GetMapping("{id}")
	    public ResponseEntity<?> findById(@PathVariable Long id) {
	    	Optional<FindUserDTO> findDTO = this.service.findById(id);	    	
	    	if(findDTO.isPresent())
	    	{
	    		return new ResponseEntity<>(findDTO.get(), HttpStatus.OK);		        
	    	}
	    	else
	    	{
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }
	    @PostMapping
	    public ResponseEntity<PostUserDTO> save(@RequestBody PostUserDTO postUserDTO) {
	    	
	        this.service.save(postUserDTO);
	        return new ResponseEntity<>(postUserDTO, HttpStatus.CREATED);
	    }

	    @PutMapping
	    public ResponseEntity<PutUserDTO> update(@RequestBody PutUserDTO putUserDTO) {
	        this.service.update(putUserDTO);
	        return new ResponseEntity<>(putUserDTO, HttpStatus.CREATED);
	    }

	    @DeleteMapping
	    public ResponseEntity<DeleteUserDTO> delete(@RequestBody DeleteUserDTO deleteUserDTO) {
	        this.service.delete(deleteUserDTO);
	        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	    }
}
