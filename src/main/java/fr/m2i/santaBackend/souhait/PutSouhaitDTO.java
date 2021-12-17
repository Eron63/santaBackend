package fr.m2i.santaBackend.souhait;

import fr.m2i.santaBackend.models.Cadeau;
import fr.m2i.santaBackend.models.Liste;
import fr.m2i.santaBackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutSouhaitDTO {
	
	private int id_souhait;
	
	private Cadeau cadeau_in;
	
	private Liste in_liste;
	
	private User santa;	

}
