package cl.uv.ici.arq.labs.demo.dtos;

import cl.uv.ici.arq.labs.demo.entities.UserEntity;
import lombok.Data;

@Data
public class ProfileDTO {

	private String profileId;
	private String name;
	private UserEntity user;
	//private ListEntity reproductionList;
	
}
