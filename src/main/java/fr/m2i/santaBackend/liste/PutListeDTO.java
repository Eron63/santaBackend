package fr.m2i.santaBackend.liste;

import fr.m2i.santaBackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutListeDTO {
	
	private Long id_liste;
	
	private String nom_liste;
	
	private User enfant;

}
