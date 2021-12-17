package fr.m2i.santaBackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@Table(name="cadeaux")
@AllArgsConstructor
@NoArgsConstructor
public class Cadeau {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cadeau;
	
	private String url_cadeau;
	
	private String nom_cadeau;	
	
	private Double prix_cadeau;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id_souhait")
	private Collection<Souhait> souhaits;
	

}
