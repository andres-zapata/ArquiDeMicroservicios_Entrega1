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
import cl.uv.ici.arq.labs.demo.dtos.ProfileDTO;
import cl.uv.ici.arq.labs.demo.service.ProfileService;


@RestController
@RequestMapping("/profiles")

public class ProfileController {

	@Autowired
	CustomConfig config;
	
	@Autowired
	ProfileService service;
	
	@GetMapping("/configuration")
	public ResponseEntity<CustomConfig> getProperties(){
		return new ResponseEntity<CustomConfig>(config,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<ProfileDTO> save(@RequestBody @Valid ProfileDTO profileDTO) {
		return new ResponseEntity<>(service.createProfile(profileDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{profileId}")
	public ResponseEntity<ProfileDTO> findById(@PathVariable String profileId) {
		return new ResponseEntity<>(service.getProfile(profileId), HttpStatus.OK);
	}
	

	@GetMapping
	public ResponseEntity<List<ProfileDTO>> findAll() {
		return new ResponseEntity<>(service.getProfiles(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ProfileDTO> update(@RequestBody @Valid ProfileDTO profileDTO) {
		return new ResponseEntity<>(service.updateProfile(profileDTO), HttpStatus.OK);
	}
//	@DeleteMapping("/{profileId}")
//	public ResponseEntity<ProfileDTO> deleteProfile(@PathVariable String profileId) {
//		return new ResponseEntity<>(service.deleteProfile(profileId), HttpStatus.OK);
//	}
	

}
