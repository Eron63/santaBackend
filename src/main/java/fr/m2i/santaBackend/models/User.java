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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
	
	private String nom_user;
	
	private String prenom_user;
	
	private String adresse_user;
	
	private Boolean is_santa_user;
	
	private String password;
	
	@OneToMany(mappedBy = "id_souhait")
	private Collection<Souhait> cadeaux_of_santa;	
	
	@OneToOne(mappedBy = "enfant")
	private Liste liste_enfant;

}
