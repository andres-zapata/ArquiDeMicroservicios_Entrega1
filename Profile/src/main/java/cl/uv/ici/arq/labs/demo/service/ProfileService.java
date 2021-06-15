package cl.uv.ici.arq.labs.demo.service;

import java.util.List;

import cl.uv.ici.arq.labs.demo.dtos.ProfileDTO;

public interface ProfileService {

	public ProfileDTO createProfile(ProfileDTO profile);
	public boolean deleteProfile(String idProfile);
	public List<ProfileDTO> getProfiles();
	public ProfileDTO updateProfile(ProfileDTO profile);
	public ProfileDTO getProfile(String idProfile);
	
	

}
