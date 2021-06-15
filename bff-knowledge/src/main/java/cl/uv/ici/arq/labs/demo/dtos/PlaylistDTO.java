package cl.uv.ici.arq.labs.demo.dtos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class PlaylistDTO {

	private String playlistId;
	private String name;
	private ArrayList<String> videoList;	
}
