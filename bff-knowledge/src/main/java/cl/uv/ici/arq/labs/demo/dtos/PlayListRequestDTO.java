package cl.uv.ici.arq.labs.demo.dtos;

import java.util.List;

import lombok.Data;

@Data
public class PlayListRequestDTO {

	public PlayListRequestDTO() {

	}

	public PlayListRequestDTO(String playListId, List<String> skillList) {
		super();
		this.playListId = playListId;
		//this.skillList = skillList;
	}

	private String playListId;
	//private List<String> skillList;
}
