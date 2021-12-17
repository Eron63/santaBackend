package fr.m2i.santaBackend.souhait;

import fr.m2i.santaBackend.models.Cadeau;
import fr.m2i.santaBackend.models.Liste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSouhaitDTO {
	
	private Cadeau cadeau_in;
	
	private Liste in_liste;

}
