package fr.m2i.santaBackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="souhaits")
@AllArgsConstructor
@NoArgsConstructor
public class Souhait {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_souhait;
	
	@ManyToOne
    @JoinColumn(name = "id_cadeau")
	private Cadeau cadeau;	
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "id_liste")
	private Liste liste;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "id_santa")
	private User santa;	

}
