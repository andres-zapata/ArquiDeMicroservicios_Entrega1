package cl.uv.ici.arq.labs.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.demo.dtos.ProfileDTO;
import cl.uv.ici.arq.labs.demo.dtos.UserDTO;
import cl.uv.ici.arq.labs.demo.entities.ProfileEntity;
import cl.uv.ici.arq.labs.demo.mapper.MapperUtils;
import cl.uv.ici.arq.labs.demo.service.ProfileService;
import cl.uv.ici.arq.labs.demo.repository.ProfileRepository;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {


	@Autowired
	ProfileRepository profileRepository;
	
	private UserDTO userDTO;
	
	private ProfileEntity mapProfileEntity(ProfileDTO profileDTO) {
		ProfileEntity profile= new ProfileEntity();		
		profile.setName(profileDTO.getName());
		profile.setUserId(userDTO.getUserId());
//		profile.setList(profileDTO.getReproductionList());
		return profile;
	}
	
	@Override
	public ProfileDTO createProfile(ProfileDTO profileDTO) {
		ProfileEntity profileEntity = this.mapProfileEntity(profileDTO);
		profileEntity =this.profileRepository.save(profileEntity);
		profileDTO=(ProfileDTO) MapperUtils.map(profileEntity, ProfileDTO.class);
		return profileDTO;
	}


	@Override
	public boolean deleteProfile(String idProfile) {
		boolean delete=true;		
		this.profileRepository.deleteById(UUID.fromString(idProfile));		
		return delete;
	}

	@Override
	public ProfileDTO updateProfile(ProfileDTO profileDTO) {
		ProfileEntity profileEntity = this.mapProfileEntity(profileDTO);
		profileEntity.setProfileId(UUID.fromString(profileDTO.getProfileId()));
		profileEntity =this.profileRepository.save(profileEntity);
		profileDTO=(ProfileDTO) MapperUtils.map(profileEntity, ProfileDTO.class);
		return profileDTO;
	}

	@Override
	public ProfileDTO getProfile(String idProfile) {
		return (ProfileDTO) MapperUtils.map(this.profileRepository.findById(UUID.fromString(idProfile)).get(), ProfileDTO.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfileDTO> getProfiles() {
		 return (List<ProfileDTO>) MapperUtils.mapAsList(profileRepository.findAll(), new TypeToken<List<ProfileDTO>>() {}.getType());
	}


}
