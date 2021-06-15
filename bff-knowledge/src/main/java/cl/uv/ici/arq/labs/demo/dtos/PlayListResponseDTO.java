package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PlayListResponseDTO {
	

	
	public PlayListResponseDTO(PlaylistDTO playList) {
		this.playList=playList;
		//this.listSkill=skills;
	}
	
	public PlayListResponseDTO(List<PlaylistDTO> playLists) {
		this.playLists=playLists;
		//this.listSkill=skills;
	}
	
	public PlayListResponseDTO() {}
	
	private PlaylistDTO playList;
	private List<PlaylistDTO> playLists;

	//private List<SkillDTO> listSkill;

}
