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

import fr.m2i.santaBackend.liste.DeleteListeDTO;
import fr.m2i.santaBackend.liste.FindListeDTO;
import fr.m2i.santaBackend.liste.PostListeDTO;
import fr.m2i.santaBackend.liste.PutListeDTO;
import fr.m2i.santaBackend.services.ListeService;

@RestController
@RequestMapping("listes")
@CrossOrigin
public class ListeController {
	
	    @Autowired
	    ListeService service;

	    @GetMapping
	    public ResponseEntity<List<FindListeDTO>> findAll() {
	        return ResponseEntity.ok(this.service.findAll());
	    }
	    
	    @GetMapping("{id}")
	    public ResponseEntity<?> findById(@PathVariable Long id) {
	    	Optional<FindListeDTO> findDTO = this.service.findById(id);
	    	
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
	    public ResponseEntity<PostListeDTO> save(@RequestBody PostListeDTO postListeDTO) {
	    	
	        this.service.save(postListeDTO);
	        return new ResponseEntity<>(postListeDTO, HttpStatus.CREATED);
	    }

	    @PutMapping
	    public ResponseEntity<PutListeDTO> update(@RequestBody PutListeDTO putListeDTO) {
	        this.service.update(putListeDTO);
	        return new ResponseEntity<>(putListeDTO, HttpStatus.CREATED);
	    }

	    @DeleteMapping
	    public ResponseEntity<DeleteListeDTO> delete(@RequestBody DeleteListeDTO deleteListeDTO) {
	        this.service.delete(deleteListeDTO);
	        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
	    }
}
