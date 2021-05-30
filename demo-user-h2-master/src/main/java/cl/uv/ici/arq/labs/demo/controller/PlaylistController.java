package cl.uv.ici.arq.labs.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.labs.demo.config.CustomConfig;
import cl.uv.ici.arq.labs.demo.dtos.PlaylistDTO;
import cl.uv.ici.arq.labs.demo.dtos.VideoDTO;
import cl.uv.ici.arq.labs.demo.service.PlaylistService;


@RestController
@RequestMapping("/playlists")

public class PlaylistController {

	@Autowired
	CustomConfig config;
	
	@Autowired
	PlaylistService service;
	
	@GetMapping("/configuration")
	public ResponseEntity<CustomConfig> getProperties(){
		return new ResponseEntity<CustomConfig>(config,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
		return new ResponseEntity<>(service.createPlaylist(playlistDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{playlistId}")
	public ResponseEntity<PlaylistDTO> deletePlaylist(@PathVariable String playlistId) {
		return new ResponseEntity<>(service.deletePlaylist(playlistId), HttpStatus.OK);
	}
	
	@GetMapping("/{profileId}")
	public ResponseEntity<PlaylistDTO> getPlaylist(@PathVariable String playlistId) {
		return new ResponseEntity<>(service.getPlaylist(playlistId), HttpStatus.OK);
	}
	
	@PostMapping("/{playlistId}/{videoId}")
	public ResponseEntity<PlaylistDTO> addVideo(@PathVariable String videoId, @PathVariable String playListId) {
		return new ResponseEntity<>(service.saveVideo(videoId, playListId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{videoId}")
	public ResponseEntity<PlaylistDTO> deleteVideo(@PathVariable String videoId) {
		return new ResponseEntity<>(service.deleteVideo(videoId), HttpStatus.OK);
	}

}
