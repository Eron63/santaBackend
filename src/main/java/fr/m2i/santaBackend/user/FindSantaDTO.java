package fr.m2i.santaBackend.user;

import java.util.Collection;

import fr.m2i.santaBackend.models.Souhait;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class FindSantaDTO extends FindUserDTO{
	
	private String nom_user;
	
	private String prenom_user;
	
	private String adresse_user;
	
	private Boolean is_santa_user;
	
	private Collection<Souhait> cadeaux_of_santa;	

}
