package cl.uv.ici.arq.labs.demo.dtos;

import 
import lombok.Data;


@Data
public class ProfileDTO {

	private String profileId;
	private String name;
	private UserEntity user;
	//private ListEntity reproductionList;
	
}
