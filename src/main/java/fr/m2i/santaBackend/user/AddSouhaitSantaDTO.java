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
public class AddSouhaitSantaDTO extends PutUserDTO{
	private Long id_user;
	
	private Collection<Souhait> cadeaux_of_santa;

}
