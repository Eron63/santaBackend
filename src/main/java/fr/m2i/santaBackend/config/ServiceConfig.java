package fr.m2i.santaBackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.m2i.santaBackend.repositories.*;
import fr.m2i.santaBackend.services.*;


@Configuration
public class ServiceConfig {
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	 
	@Bean
	public UserService UserService(UserRepository repository, ModelMapper mapper) {
	    return new UserService(repository, mapper);
	}
	 
	@Bean
	public CadeauService CadeauService(CadeauRepository repository, ModelMapper mapper) {
	    return new CadeauService(repository, mapper);
	}
	
	@Bean
	public ListeService ListeService(ListeRepository repository, ModelMapper mapper) {
	    return new ListeService(repository, mapper);
	}
	    
	@Bean
	public SouhaitService SouhaitService(SouhaitRepository repository, ModelMapper mapper) {
	    return new SouhaitService(repository, mapper);
	}

}
