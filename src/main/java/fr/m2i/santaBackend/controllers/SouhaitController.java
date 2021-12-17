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

import fr.m2i.santaBackend.services.SouhaitService;
import fr.m2i.santaBackend.souhait.DeleteSouhaitDTO;
import fr.m2i.santaBackend.souhait.FindSouhaitDTO;
import fr.m2i.santaBackend.souhait.PostSouhaitDTO;
import fr.m2i.santaBackend.souhait.PutSouhaitDTO;

@RestController
@RequestMapping("souhaits")
@CrossOrigin
public class SouhaitController {
	
	    @Autowired
	    SouhaitService service;

	    @GetMapping
	    public ResponseEntity<List<FindSouhaitDTO>> findAll() {
	        return ResponseEntity.ok(this.service.findAll());
	    }
	    
	    @GetMapping("{id}")
	    public ResponseEntity<?> findById(@PathVariable Long id) {
	    	Optional<FindSouhaitDTO> findDTO = this.service.findById(id);
	    	
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
	    public ResponseEntity<PostSouhaitDTO> save(@RequestBody PostSouhaitDTO postSouhaitDTO) {
	    	
	        this.service.save(postSouhaitDTO);
	        return new ResponseEntity<>(postSouhaitDTO, HttpStatus.CREATED);
	    }

	    @PutMapping
	    public ResponseEntity<PutSouhaitDTO> update(@RequestBody PutSouhaitDTO putSouhaitDTO) {
	        this.service.update(putSouhaitDTO);
	        return new ResponseEntity<>(putSouhaitDTO, HttpStatus.CREATED);
	    }

	    @DeleteMapping
	    public ResponseEntity<DeleteSouhaitDTO> delete(@RequestBody DeleteSouhaitDTO deleteSouhaitDTO) {
	        this.service.delete(deleteSouhaitDTO);
	        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	    }
}
