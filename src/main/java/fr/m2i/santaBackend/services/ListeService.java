package fr.m2i.santaBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import fr.m2i.santaBackend.liste.DeleteListeDTO;
import fr.m2i.santaBackend.liste.FindListeDTO;
import fr.m2i.santaBackend.liste.PostListeDTO;
import fr.m2i.santaBackend.liste.PutListeDTO;
import fr.m2i.santaBackend.models.Liste;
import fr.m2i.santaBackend.repositories.ListeRepository;

public class ListeService {
	
	 ListeRepository repository;
	 ModelMapper mapper;
	 
	 public ListeService(ListeRepository repository, ModelMapper mapper) {
		 this.repository = repository;
		 this.mapper = mapper;
	 }
	 
	 public List<FindListeDTO> findAll() {
	        List<Liste> listes = this.repository.findAll();
	        List<FindListeDTO> listesDTOS = new ArrayList<>();
	        listes.forEach(liste -> listesDTOS.add(mapper.map(liste, FindListeDTO.class)));
	        return listesDTOS;
	    }

	    public FindListeDTO save(PostListeDTO postListeDTO) {
	        Liste liste = mapper.map(postListeDTO, Liste.class);
	        return mapper.map(this.repository.save(liste), FindListeDTO.class);
	    }

	    public FindListeDTO update(PutListeDTO putListeDTO) {
	        Liste liste = mapper.map(putListeDTO, Liste.class);
	        return mapper.map(this.repository.save(liste), FindListeDTO.class);
	    }

	    public Optional<FindListeDTO> findById(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindListeDTO.class) != null)
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindListeDTO.class)) ;
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }

	    public void delete(DeleteListeDTO deleteListeDTO) {
	        this.repository.delete(mapper.map(deleteListeDTO, Liste.class));
	    }

}
