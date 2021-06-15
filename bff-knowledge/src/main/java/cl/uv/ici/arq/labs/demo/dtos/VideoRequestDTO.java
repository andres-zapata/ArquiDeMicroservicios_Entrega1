package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class VideoRequestDTO {

	public VideoRequestDTO() {

	}

	public VideoRequestDTO(String videoId, List<String> skillList) {
		super();
		this.videoId = videoId;
		//this.skillList = skillList;
	}

	private String videoId;
	//private List<String> skillList;
}
