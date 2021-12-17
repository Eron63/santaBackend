package fr.m2i.santaBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import fr.m2i.santaBackend.models.Souhait;
import fr.m2i.santaBackend.repositories.SouhaitRepository;
import fr.m2i.santaBackend.souhait.DeleteSouhaitDTO;
import fr.m2i.santaBackend.souhait.FindSouhaitDTO;
import fr.m2i.santaBackend.souhait.PostSouhaitDTO;
import fr.m2i.santaBackend.souhait.PutSouhaitDTO;

public class SouhaitService {
	
	 SouhaitRepository repository;
	 ModelMapper mapper;
	 
	 public SouhaitService(SouhaitRepository repository, ModelMapper mapper) {
		 this.repository = repository;
		 this.mapper = mapper;
	 }
	 
	 public List<FindSouhaitDTO> findAll() {
	        List<Souhait> souhaits = this.repository.findAll();
	        List<FindSouhaitDTO> souhaitsDTOS = new ArrayList<>();
	        souhaits.forEach(souhait -> souhaitsDTOS.add(mapper.map(souhait, FindSouhaitDTO.class)));
	        return souhaitsDTOS;
	    }

	    public FindSouhaitDTO save(PostSouhaitDTO postSouhaitDTO) {
	        Souhait souhait = mapper.map(postSouhaitDTO, Souhait.class);
	        return mapper.map(this.repository.save(souhait), FindSouhaitDTO.class);
	    }

	    public FindSouhaitDTO update(PutSouhaitDTO putSouhaitDTO) {
	        Souhait souhait = mapper.map(putSouhaitDTO, Souhait.class);
	        return mapper.map(this.repository.save(souhait), FindSouhaitDTO.class);
	    }

	    public Optional<FindSouhaitDTO> findById(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindSouhaitDTO.class) != null)
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindSouhaitDTO.class)) ;
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }

	    public void delete(DeleteSouhaitDTO deleteSouhaitDTO) {
	        this.repository.delete(mapper.map(deleteSouhaitDTO, Souhait.class));
	    }

}
