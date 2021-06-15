package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ProfileRequestDTO {

	public ProfileRequestDTO() {

	}

	public ProfileRequestDTO(String profileId, List<String> skillList) {
		super();
		this.profileId = profileId;
		//this.skillList = skillList;
	}

	private String profileId;
	//private List<String> skillList;
}
