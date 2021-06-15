package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class VideoResponseDTO {
	

	
	public VideoResponseDTO(VideoDTO video) {
		this.video=video;
		//this.listSkill=skills;
	}
	
	public VideoResponseDTO(List<VideoDTO> videos) {
		this.videos=videos;
		//this.listSkill=skills;
	}
	
	public VideoResponseDTO() {}
	
	private VideoDTO video;
	private List<VideoDTO> videos;

	//private List<SkillDTO> listSkill;

}
