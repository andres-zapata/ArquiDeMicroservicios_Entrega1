package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class KnowledgeResponseDTO {
	

	
	public KnowledgeResponseDTO(UserDTO user) {
		this.user=user;
		//this.listSkill=skills;
	}
	
	public KnowledgeResponseDTO(List<UserDTO> users) {
		this.users=users;
		//this.listSkill=skills;
	}
	
	public KnowledgeResponseDTO() {}
	
	private UserDTO user;
	private List<UserDTO> users;

	//private List<SkillDTO> listSkill;

}
