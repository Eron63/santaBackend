package fr.m2i.santaBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.santaBackend.services.UserService;
import fr.m2i.santaBackend.user.AddSouhaitSantaDTO;
import fr.m2i.santaBackend.user.FindSantaDTO;
import fr.m2i.santaBackend.user.FindUserDTO;
import fr.m2i.santaBackend.user.PutUserDTO;

@RestController
@RequestMapping("santas")
@CrossOrigin
public class SantaController {
	
	@Autowired
    UserService service;
	

    @GetMapping
    public ResponseEntity<List<FindSantaDTO>> findAllSanta() {
        return ResponseEntity.ok(this.service.findAllSanta());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> findByIdSanta(@PathVariable Long id) {
    	Optional<FindUserDTO> findSantaDTO = this.service.findByIdSanta(id);
    	
    	if(findSantaDTO.isPresent())
    	{
    		return new ResponseEntity<>(findSantaDTO.get(), HttpStatus.OK);		        
    	}
    	else
    	{
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PutMapping("/addsouhaits")
    public ResponseEntity<PutUserDTO> update(@RequestBody AddSouhaitSantaDTO addSouhaitSantaDTO) {
        this.service.update(addSouhaitSantaDTO);
        return new ResponseEntity<>(addSouhaitSantaDTO, HttpStatus.CREATED);
    }

}
