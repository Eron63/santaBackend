package fr.m2i.santaBackend.liste;

import java.util.Collection;

import fr.m2i.santaBackend.models.Souhait;
import fr.m2i.santaBackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindListeDTO {
	
	private Long id_liste;
	
	private String nom_liste;
	
	private User enfant;
	
	private Collection<Souhait> cadeaux_in;

}
