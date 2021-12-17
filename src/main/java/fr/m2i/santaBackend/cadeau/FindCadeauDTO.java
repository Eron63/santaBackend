package fr.m2i.santaBackend.cadeau;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindCadeauDTO {
	
	private String url_cadeau;
	
	private String nom_cadeau;	
	
	private Double prix_cadeau;
	
}
