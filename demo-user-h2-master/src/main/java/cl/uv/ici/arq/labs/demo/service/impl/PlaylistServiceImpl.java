package cl.uv.ici.arq.labs.demo.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.demo.dtos.PlaylistDTO;
import cl.uv.ici.arq.labs.demo.entities.PlaylistEntity;
import cl.uv.ici.arq.labs.demo.mapper.MapperUtils;
import cl.uv.ici.arq.labs.demo.repository.PlaylistRepository;
import cl.uv.ici.arq.labs.demo.service.PlaylistService;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;
		
	private PlaylistEntity mapPlaylistEntity(PlaylistDTO playlistDTO) {
		PlaylistEntity playlist= new PlaylistEntity();		
		playlist.setName(playlistDTO.getName());
		playlist.setVideoList(playlistDTO.getVideoList());
		return playlist;
	}
	
	@Override
	public PlaylistDTO createPlaylist(PlaylistDTO playlistDTO) {
		PlaylistEntity playlistEntity = this.mapPlaylistEntity(playlistDTO);
		playlistEntity =this.playlistRepository.save(playlistEntity);
		playlistDTO=(PlaylistDTO) MapperUtils.map(playlistEntity, PlaylistDTO.class);
		return playlistDTO;
	}


	@Override
	public boolean deletePlaylist(String idPlaylist) {
		boolean delete=true;		
		this.playlistRepository.deleteById(UUID.fromString(idPlaylist));		
		return delete;
	}

	@Override
	public PlaylistDTO getPlaylist(String idPlaylist) {
		return (PlaylistDTO) MapperUtils.map(this.playlistRepository.findById(UUID.fromString(idPlaylist)).get(), PlaylistDTO.class);
	}

	@Override
	public boolean addVideo(@Valid String videoId) {
		boolean add=true;		
		this.playlistRepository.save(videoId);		
		return add;
	}

	@Override
	public boolean deleteVideo(@Valid String videoId) {
		boolean delete=true;		
		this.playlistRepository.deleteById(UUID.fromString(videoId));		
		return delete;
	}
	

}
