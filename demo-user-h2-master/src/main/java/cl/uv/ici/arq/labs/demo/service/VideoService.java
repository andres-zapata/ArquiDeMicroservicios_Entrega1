package cl.uv.ici.arq.labs.demo.service;

import java.util.List;

import cl.uv.ici.arq.labs.demo.dtos.VideoDTO;

public interface VideoService {

	public VideoDTO createVideo(VideoDTO video);
	public boolean removeVideo(String idvideo);
	public List<VideoDTO> getVideo();
	public VideoDTO updateVideo(VideoDTO video);
	public VideoDTO getVideo(String idVideo);

	
	

}
