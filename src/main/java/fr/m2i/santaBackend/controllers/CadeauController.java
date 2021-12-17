package fr.m2i.santaBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.santaBackend.cadeau.DeleteCadeauDTO;
import fr.m2i.santaBackend.cadeau.FindCadeauDTO;
import fr.m2i.santaBackend.cadeau.PostCadeauDTO;
import fr.m2i.santaBackend.cadeau.PutCadeauDTO;
import fr.m2i.santaBackend.services.CadeauService;

@RestController
@RequestMapping("cadeaux")
@CrossOrigin
public class CadeauController {
	
	    @Autowired
	    CadeauService service;

	    @GetMapping
	    public ResponseEntity<List<FindCadeauDTO>> findAll() {
	        return ResponseEntity.ok(this.service.findAll());
	    }
	    
	    @GetMapping("{id}")
	    public ResponseEntity<?> findById(@PathVariable Long id) {
	    	Optional<FindCadeauDTO> findDTO = this.service.findById(id);
	    	
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
	    public ResponseEntity<PostCadeauDTO> save(@RequestBody PostCadeauDTO postCadeauDTO) {
	    	
	        this.service.save(postCadeauDTO);
	        return new ResponseEntity<>(postCadeauDTO, HttpStatus.CREATED);
	    }

	    @PutMapping
	    public ResponseEntity<PutCadeauDTO> update(@RequestBody PutCadeauDTO putCadeauDTO) {
	        this.service.update(putCadeauDTO);
	        return new ResponseEntity<>(putCadeauDTO, HttpStatus.CREATED);
	    }

	    @DeleteMapping
	    public ResponseEntity<DeleteCadeauDTO> delete(@RequestBody DeleteCadeauDTO deleteCadeauDTO) {
	        this.service.delete(deleteCadeauDTO);
	        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	    }
}
