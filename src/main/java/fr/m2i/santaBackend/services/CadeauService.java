package fr.m2i.santaBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import fr.m2i.santaBackend.cadeau.DeleteCadeauDTO;
import fr.m2i.santaBackend.cadeau.FindCadeauDTO;
import fr.m2i.santaBackend.cadeau.PostCadeauDTO;
import fr.m2i.santaBackend.cadeau.PutCadeauDTO;
import fr.m2i.santaBackend.models.Cadeau;
import fr.m2i.santaBackend.repositories.CadeauRepository;

public class CadeauService {
	
	 CadeauRepository repository;
	 ModelMapper mapper;
	 
	 public CadeauService(CadeauRepository repository, ModelMapper mapper) {
		 this.repository = repository;
		 this.mapper = mapper;
	 }
	 
	 public List<FindCadeauDTO> findAll() {
	        List<Cadeau> cadeaus = this.repository.findAll();
	        List<FindCadeauDTO> cadeausDTOS = new ArrayList<>();
	        cadeaus.forEach(cadeau -> cadeausDTOS.add(mapper.map(cadeau, FindCadeauDTO.class)));
	        return cadeausDTOS;
	    }

	    public FindCadeauDTO save(PostCadeauDTO postCadeauDTO) {
	        Cadeau cadeau = mapper.map(postCadeauDTO, Cadeau.class);
	        return mapper.map(this.repository.save(cadeau), FindCadeauDTO.class);
	    }

	    public FindCadeauDTO update(PutCadeauDTO putCadeauDTO) {
	        Cadeau cadeau = mapper.map(putCadeauDTO, Cadeau.class);
	        return mapper.map(this.repository.save(cadeau), FindCadeauDTO.class);
	    }

	    public Optional<FindCadeauDTO> findById(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindCadeauDTO.class) != null)
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindCadeauDTO.class)) ;
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }

	    public void delete(DeleteCadeauDTO deleteCadeauDTO) {
	        this.repository.delete(mapper.map(deleteCadeauDTO, Cadeau.class));
	    }

}
