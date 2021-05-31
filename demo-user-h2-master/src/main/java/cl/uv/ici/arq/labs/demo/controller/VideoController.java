package cl.uv.ici.arq.labs.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.labs.demo.config.CustomConfig;
import cl.uv.ici.arq.labs.demo.dtos.UserDTO;
import cl.uv.ici.arq.labs.demo.dtos.VideoDTO;
import cl.uv.ici.arq.labs.demo.service.UserService;
import cl.uv.ici.arq.labs.demo.service.VideoService;

@RestController
@RequestMapping("/videos")

public class VideoController {

	@Autowired
	CustomConfig config;
	
	@Autowired
	VideoService service;
	
	@GetMapping("/configuration")
	public ResponseEntity<CustomConfig> getProperties(){
		return new ResponseEntity<CustomConfig>(config,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<VideoDTO> save(@RequestBody @Valid VideoDTO videoDTO) {
		return new ResponseEntity<>(service.createVideo(videoDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{videoId}")
	public ResponseEntity<VideoDTO> findById(@PathVariable String videoId) {
		return new ResponseEntity<>(service.getVideo(videoId), HttpStatus.OK);
	}
	

	@GetMapping
	public ResponseEntity<List<VideoDTO>> findAll() {
		return new ResponseEntity<>(service.getVideos(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<VideoDTO> update(@RequestBody @Valid VideoDTO videoDTO) {
		return new ResponseEntity<>(service.updateVideo(videoDTO), HttpStatus.OK);
	}
	
	

}
