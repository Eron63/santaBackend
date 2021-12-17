package fr.m2i.santaBackend.user;

import fr.m2i.santaBackend.models.Liste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class FindEnfantDTO extends FindUserDTO{
	
private String nom_user;
	
	private String prenom_user;
	
	private String adresse_user;
	
	private Boolean is_santa_user;
	
	private Liste liste_enfant;

}
