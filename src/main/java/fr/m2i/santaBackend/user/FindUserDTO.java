package fr.m2i.santaBackend.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindUserDTO {
			
	private String nom_user;
	
	private String prenom_user;
	
	private String adresse_user;
	
	private Boolean is_santa_user;

}
