package fr.m2i.santaBackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name="listes")
@AllArgsConstructor
@NoArgsConstructor
public class Liste {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_liste;
	
	private String nom_liste;
		
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_enfant", referencedColumnName = "id_user")
	private User enfant;
	
	@OneToMany
	@JoinColumn(name = "id_souhait")
	private Collection<Souhait> souhaits;
}
