package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ProfileResponseDTO {
	

	
	public ProfileResponseDTO(ProfileDTO playList) {
		this.profile=profile;
		//this.listSkill=skills;
	}
	
	public ProfileResponseDTO(List<ProfileDTO> playLists) {
		this.profiles=profiles;
		//this.listSkill=skills;
	}
	
	public ProfileResponseDTO() {}
	
	private ProfileDTO profile;
	private List<ProfileDTO> profiles;

	//private List<SkillDTO> listSkill;

}
