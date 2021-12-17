package fr.m2i.santaBackend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;

import fr.m2i.santaBackend.models.User;
import fr.m2i.santaBackend.repositories.UserRepository;
import fr.m2i.santaBackend.user.DeleteUserDTO;
import fr.m2i.santaBackend.user.FindEnfantDTO;
import fr.m2i.santaBackend.user.FindSantaDTO;
import fr.m2i.santaBackend.user.FindUserDTO;
import fr.m2i.santaBackend.user.PostUserDTO;
import fr.m2i.santaBackend.user.PutUserDTO;


public class UserService {
	
	 UserRepository repository;
	 ModelMapper mapper;
	 
	 public UserService(UserRepository repository, ModelMapper mapper) {
		 this.repository = repository;
		 this.mapper = mapper;
	 }
	 
	 	public List<FindUserDTO> findAll() {
	        List<User> users = this.repository.findAll();
	        List<FindUserDTO> usersDTOS = new ArrayList<>();
	        users.forEach(liste -> usersDTOS.add(mapper.map(liste, FindUserDTO.class)));
	        return usersDTOS;
	    }
	 	
	 	public List<FindSantaDTO> findAllSanta() {
	        List<User> users = this.repository.findAll();
	        List<FindSantaDTO> santasDTOS = new ArrayList<>();
	        for(User user:users) {
	        	if(user.getIs_santa_user()) {
	        		santasDTOS.add(mapper.map(user, FindSantaDTO.class));
	        	}
	        }
	        return santasDTOS;
	    }
	 	
	 	public List<FindEnfantDTO> findAllEnfant() {
	        List<User> users = this.repository.findAll();
	        List<FindEnfantDTO> enfantsDTOS = new ArrayList<>();
	        for(User user:users) {
	        	if(!user.getIs_santa_user()) {
	        		enfantsDTOS.add(mapper.map(user, FindEnfantDTO.class));
	        	}
	        }
	        return enfantsDTOS;
	    }	 	
	 	

	    public FindUserDTO save(PostUserDTO postUserDTO) {
	        User user = mapper.map(postUserDTO, User.class);
	        return mapper.map(this.repository.save(user), FindUserDTO.class);
	    }

	    public FindUserDTO update(PutUserDTO putUserDTO) {
	        User user = mapper.map(putUserDTO, User.class);
	        return mapper.map(this.repository.save(user), FindUserDTO.class);
	    }

	    public Optional<FindUserDTO> findById(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindUserDTO.class) != null)
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindUserDTO.class)) ;
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }
	    
	    public Optional<FindUserDTO> findByIdSanta(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindSantaDTO.class) != null && this.repository.findById(id).get().getIs_santa_user())
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindSantaDTO.class)) ;	    		
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }
	    
	    public Optional<FindUserDTO> findByIdEnfant(Long id) {
	    	if(mapper.map(this.repository.findById(id).get(), FindEnfantDTO.class) != null && !this.repository.findById(id).get().getIs_santa_user())
	    	{
	    		return Optional.of(mapper.map(this.repository.findById(id).get(), FindEnfantDTO.class)) ;
	    	}
	    	else {

		        return Optional.empty();
	    	}
	    }

	    public void delete(DeleteUserDTO deleteUserDTO) {
	        this.repository.delete(mapper.map(deleteUserDTO, User.class));
	    }

}
