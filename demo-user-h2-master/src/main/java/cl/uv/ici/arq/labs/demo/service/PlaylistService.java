package cl.uv.ici.arq.labs.demo.service;

import java.util.List;

import javax.validation.Valid;

import cl.uv.ici.arq.labs.demo.dtos.PlaylistDTO;

public interface PlaylistService {

	public PlaylistDTO createPlaylist(@Valid PlaylistDTO playlistDTO);
	public boolean deletePlaylist(String playlistId);
	public PlaylistDTO getPlaylist(String playlistId);
	public boolean addVideo(@Valid String videoId);
	public boolean deleteVideo(String videoId);

}
